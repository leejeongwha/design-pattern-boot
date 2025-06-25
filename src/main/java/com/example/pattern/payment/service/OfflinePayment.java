package com.example.pattern.payment.service;

import java.math.BigInteger;

import com.example.pattern.user.entity.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OfflinePayment extends PaymentAbstraction {

    public OfflinePayment(PaymentMethod paymentMethod) {
        super(paymentMethod);
    }

    @Override
    public void pay(BigInteger amount, Member member) {
        log.info("오프라인 결제 시작 - 결제 방법: {}", paymentMethod.getPaymentType());
        
        // 오프라인 결제는 별도의 검증 과정이 필요
        log.info("오프라인 매장에서 결제 진행 중...");
        
        // 결제 검증
        if (paymentMethod.validatePayment(member)) {
            // 결제 처리
            paymentMethod.processPayment(amount, member);
            log.info("오프라인 결제 완료: {}원", amount);
        } else {
            throw new RuntimeException("오프라인 결제 검증 실패");
        }
    }
    
    @Override
    public String getPaymentInfo() {
        return "오프라인 결제 - " + paymentMethod.getPaymentType();
    }
} 