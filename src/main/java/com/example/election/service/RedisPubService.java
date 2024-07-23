package com.example.election.service;

import com.example.election.config.RedisConfig;
import com.example.election.model.RedisMessage;
import com.example.election.model.SseMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class RedisPubService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ApplicationEventPublisher publisher;
    private ObjectMapper mapper = new ObjectMapper();

    public Long sendMessage(RedisMessage redisMessage) throws Exception {
        Long sendCnt = redisTemplate.convertAndSend(RedisConfig.TOPIC, redisMessage);
        log.info("redis publish total count : {}", sendCnt);
        String msg = "";
        String value = "";
        Integer proposalNumber = null;
        Map receivedMessage = mapper.readValue(redisMessage.getMessage().toString(), Map.class);

        if (redisMessage.getType().equals("Prepare")) {
            proposalNumber = (Integer) receivedMessage.get("proposalNumber");
            msg = "[Prepare] 제안자가 Prepare 요청을 발송합니다, 제안 번호 : " + proposalNumber;
            publisher.publishEvent(new SseMessage(mapper.writeValueAsString(Map.of("event", msg))));
        } else if (redisMessage.getType().equals("Accept")) {
            proposalNumber = (Integer) receivedMessage.get("proposalNumber");
            value = (String) receivedMessage.get("value");
            msg = "[Accept] 제안자가 Accept 요청을 Proposal과 함께 발송 합니다, 제안 번호 : " + proposalNumber + ", 최신 값 : " + value;
            publisher.publishEvent(new SseMessage(mapper.writeValueAsString(Map.of("event", msg))));
        }
        return sendCnt;
    }
}
