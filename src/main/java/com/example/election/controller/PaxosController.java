package com.example.election.controller;

import com.example.election.model.State;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paxos")
public class PaxosController {
    @GetMapping("/prepare")
    public String setState(String value) {
        State.state = value;
        return value;
    }
}
