package com.example.pattern.benefit.service;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class CouponApiService {
    public String callApi() {
        String couponId = UUID.randomUUID().toString();
        log.info(couponId + " 쿠폰 발송 시작!");
        return couponId;
    }
}
