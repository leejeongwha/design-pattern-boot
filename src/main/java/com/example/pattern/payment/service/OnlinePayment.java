package com.example.pattern.payment.service;

import java.math.BigInteger;

import com.example.pattern.user.entity.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OnlinePayment extends PaymentAbstraction {

    public OnlinePayment(PaymentMethod paymentMethod) {
        super(paymentMethod);
    }

    @Override
    public void pay(BigInteger amount, Member member) {
        log.info("온라인 결제 시작 - 결제 방법: {}", paymentMethod.getPaymentType());
        
        // 결제 검증
        if (paymentMethod.validatePayment(member)) {
            // 결제 처리
            paymentMethod.processPayment(amount, member);
            log.info("온라인 결제 완료: {}원", amount);
        } else {
            throw new RuntimeException("온라인 결제 검증 실패");
        }
    }
    
    @Override
    public String getPaymentInfo() {
        return "온라인 결제 - " + paymentMethod.getPaymentType();
    }
} 