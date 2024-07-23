package com.example.election.controller;

import com.example.election.model.PaxosState;
import com.example.election.model.RedisMessage;
import com.example.election.service.RedisPubService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
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
    private final ApplicationEventPublisher publisher;

    @Value("${server.port}")
    private int serverPort;

    @GetMapping("/prepare")
    public String setState(@RequestParam String value) throws Exception {

        String msg = "";
        Long acceptorCnt = 0L;
        // Phase 1: Prepare
        PaxosState.Proposer.proposalNumber++;
        acceptorCnt = redisPubService.sendMessage(new RedisMessage(serverPort + "", "Prepare", mapper.writeValueAsString(Map.of("proposalNumber", PaxosState.Proposer.proposalNumber))));

        if (acceptorCnt > (1 / 2)) {
            // Phase 3: Accept(Proposal)
            Thread.sleep(1000);
            PaxosState.state = value;
            acceptorCnt = redisPubService.sendMessage(new RedisMessage(serverPort + "", "Accept", mapper.writeValueAsString(new PaxosState.Proposal(PaxosState.Proposer.proposalNumber, value))));
        }

        return value;
    }
}
