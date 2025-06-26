package com.example.pattern.benefit.service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CouponServiceTest {
    @Test
    void 혜택_발송_스레드_테스트() throws InterruptedException {
        int numberOfThreads = 5;
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        //ExecutorService 객체가 Invoker를 의미
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            //Runnable 구현 객체가 Command를 의미
            //CouponApiService 객체가 Receiver를 의미
            Runnable doThread = new CouponService(new CouponApiService());
            executorService.execute(() -> {
                doThread.run();
                latch.countDown();
            });
        }
        latch.await();
        Assertions.assertTrue(true);
    }
}