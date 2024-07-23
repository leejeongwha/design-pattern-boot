package com.example.election.service;

import com.example.election.model.PaxosState;
import com.example.election.model.RedisMessage;
import com.example.election.model.SseMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class SseService {
    private String uuid = UUID.randomUUID().toString();
    private ObjectMapper objectMapper = new ObjectMapper();
    private final ApplicationEventPublisher publisher;
    private final RedisTemplate<String, Object> redisTemplate;


    @Value("${server.port}")
    private int serverPort;

    //    @Scheduled(fixedRate = 3000)
    private void publishEvent() throws Exception {
        log.info("{} publishEvent 발생", serverPort);
        publisher.publishEvent(new SseMessage(objectMapper.writeValueAsString(Map.of("node", serverPort, "state", PaxosState.state))));
    }

    @Scheduled(fixedRate = 3000)
    private void checkAdmin() throws Exception {
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        RedisMessage adminIdObj = (RedisMessage) ops.get("adminId");

        if (adminIdObj == null) {
            ops.set("adminId", new RedisMessage("", "", uuid), 4, TimeUnit.SECONDS);
            publisher.publishEvent(new SseMessage(objectMapper.writeValueAsString(Map.of("node", serverPort, "state", "어드민 입니다."))));
        } else if (uuid.equals(adminIdObj.getMessage())) {
            ops.set("adminId", new RedisMessage("", "", uuid), 4, TimeUnit.SECONDS);
            publisher.publishEvent(new SseMessage(objectMapper.writeValueAsString(Map.of("node", serverPort, "state", "어드민 입니다."))));
        } else {
            publisher.publishEvent(new SseMessage(objectMapper.writeValueAsString(Map.of("node", serverPort, "state", "어드민이 아닙니다."))));
        }
    }

    @PostConstruct
    public void postConstruct() {
        log.info("uuid : " + uuid);
    }
}
