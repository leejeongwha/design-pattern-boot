package com.example.election.controller;

import com.example.election.model.PaxosState;
import com.example.election.model.RedisMessage;
import com.example.election.service.RedisPubService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/paxos")
@RequiredArgsConstructor
public class PaxosController {
    private final RedisPubService redisPubService;
    private final ObjectMapper mapper = new ObjectMapper();

    @Value("${server.port}")
    private int serverPort;

    @GetMapping("/prepare")
    public String setState(@RequestParam String value) throws Exception {
        // Phase 1: Prepare
        PaxosState.Proposer.proposalNumber++;
        Long acceptorCnt = redisPubService.sendMessage(new RedisMessage(serverPort + "", "Prepare", mapper.writeValueAsString(Map.of("proposalNumber", PaxosState.Proposer.proposalNumber))));
        if (acceptorCnt > 0) {
            // Phase 3: Accept(Proposal)
            Thread.sleep(1000);
            acceptorCnt = redisPubService.sendMessage(new RedisMessage(serverPort + "", "Accept", mapper.writeValueAsString(new PaxosState.Proposal(PaxosState.Proposer.proposalNumber, value))));
        }

        PaxosState.state = value;
        return value;
    }
}
