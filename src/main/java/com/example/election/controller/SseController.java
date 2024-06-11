package com.example.election.controller;

import com.example.election.model.SseMessage;
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
    private final List<SseEmitter> clients = new CopyOnWriteArrayList<>();

    @GetMapping(value = "/state", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter connect() {
        SseEmitter sseEmitter = new SseEmitter();
        clients.add(sseEmitter);

        sseEmitter.onTimeout(() -> clients.remove(sseEmitter));
        sseEmitter.onError(throwable -> clients.remove(sseEmitter));

        return sseEmitter;
    }

    @Async
    @EventListener
    public void stockMessageHandler(SseMessage sseMessage) {
        List<SseEmitter> errorEmitters = new ArrayList<>();

        clients.forEach(emitter -> {
            try {
                emitter.send(sseMessage.getMessage(), MediaType.TEXT_PLAIN);
            } catch (Exception e) {
                errorEmitters.add(emitter);
            }
        });

        errorEmitters.forEach(clients::remove);
    }
}
