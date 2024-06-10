package com.example.election.service;

import com.example.election.model.RedisMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisPubService {
    private final RedisTemplate<String, Object> redisTemplate;

    public void sendMessage(RedisMessage redisMessage) {
        redisTemplate.convertAndSend("topic1", redisMessage);

    }
}
