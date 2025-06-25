package com.example.pattern.payment.service;

import java.math.BigInteger;

import com.example.pattern.user.entity.Member;

// Bridge 패턴의 구현 계층 인터페이스
public interface PaymentMethod {
    boolean validatePayment(Member member);
    void processPayment(BigInteger amount, Member member);
    String getPaymentType();
}
