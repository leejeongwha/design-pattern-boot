package com.example.election;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SseService {
    private final ApplicationEventPublisher publisher;

    @Scheduled(fixedRate = 1000)
    private void changePrice() {
        log.info("publishEvent 발생");
        publisher.publishEvent(new Stock((int) (Math.random() * 10) + 1));
    }
}
