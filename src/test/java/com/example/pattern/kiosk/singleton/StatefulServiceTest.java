package com.example.pattern.kiosk.singleton;

import com.example.pattern.kiosk.singleton.PageViewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class StatefulServiceTest {
    @Autowired
    private PageViewService statefulService;

    @Test
    void Stateful_서비스_테스트() throws InterruptedException {
        int numberOfThreads = 10;
        ExecutorService service = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            service.execute(() -> {
                statefulService.incr();
                latch.countDown();
            });
        }
        latch.await();
    }
}