package com.example.pattern.benefit.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CouponService implements Runnable {
    private CouponApiService couponApiService;

    public CouponService(CouponApiService couponApiService) {
        this.couponApiService = couponApiService;
    }

    @Override
    public void run() {
        String couponId = couponApiService.callApi();
        sleepThread();
        log.info(couponId + " 쿠폰 발송 완료");
    }

    private void sleepThread() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("CouponService Error", e);
        }
    }
}
