package com.example.election.controller;

import com.example.election.Stock;
import com.example.election.model.RedisMessage;
import com.example.election.service.RedisPubService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/election")
public class SseController {
    private final RedisPubService redisPubService;
    private final List<SseEmitter> clients = new CopyOnWriteArrayList<>();

    @GetMapping(value = "/emitter", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter connect() {
        SseEmitter sseEmitter = new SseEmitter();
        clients.add(sseEmitter);

        sseEmitter.onTimeout(() -> clients.remove(sseEmitter));
        sseEmitter.onError(throwable -> clients.remove(sseEmitter));

        return sseEmitter;
    }

    @GetMapping(value = "/send")
    public String send() {
        redisPubService.sendMessage(new RedisMessage("123", "test"));
        return "OK";
    }

    @Async
    @EventListener
    public void stockMessageHandler(Stock stock) {
        List<SseEmitter> errorEmitters = new ArrayList<>();

        clients.forEach(emitter -> {
            try {
                emitter.send("현재의 value값은 +" + stock.getValue() + " 입니다.", MediaType.TEXT_PLAIN);
            } catch (Exception e) {
                errorEmitters.add(emitter);
            }
        });

        errorEmitters.forEach(clients::remove);
    }
}
