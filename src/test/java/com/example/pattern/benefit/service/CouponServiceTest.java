package com.example.pattern.benefit.service;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CouponServiceTest {
    @Test
    void 혜택_발송_스레드_테스트() throws InterruptedException {
        int numberOfThreads = 5;
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        //ExecutorService 객체가 Invoker를 의미
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        for (int i = 1; i <= 10; i++) {
            //Runnable 객체가 Command를 의미
            //BenefitService 객체가 Receiver를 의미
            Runnable doThread = new CouponService("CouponThread" + i);
            executorService.execute(doThread);
            latch.countDown();
        }
        latch.await();
    }
}