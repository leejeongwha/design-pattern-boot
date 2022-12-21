package com.example.pattern.benefit.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CouponService implements Runnable {
    private String threadName;

    public CouponService(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        log.info(Thread.currentThread().getName() + "의 " + threadName + "이 시작되었습니다.");
        sleepThread();
        log.info(Thread.currentThread().getName() + "가 종료되었습니다");
    }

    private void sleepThread() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("CouponService Error", e);
        }
    }
}
