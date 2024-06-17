package com.example.election.service;

import com.example.election.model.PaxosState;
import com.example.election.model.SseMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class SseService {
    private ObjectMapper objectMapper = new ObjectMapper();
    private final ApplicationEventPublisher publisher;

    @Value("${server.port}")
    private int serverPort;

    @Scheduled(fixedRate = 3000)
    private void publishEvent() throws Exception {
        log.info("{} publishEvent 발생", serverPort);
        publisher.publishEvent(new SseMessage(objectMapper.writeValueAsString(Map.of("node", serverPort, "state", PaxosState.state))));
    }
}
