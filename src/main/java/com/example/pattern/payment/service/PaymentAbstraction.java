package com.example.pattern.payment.service;

import java.math.BigInteger;

import com.example.pattern.user.entity.Member;

// Bridge 패턴의 추상화 계층 인터페이스
public abstract class PaymentAbstraction {
    protected PaymentMethod paymentMethod;

    protected PaymentAbstraction(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public abstract void pay(BigInteger amount, Member member);
    
    public String getPaymentInfo() {
        return "결제 - " + paymentMethod.getPaymentType();
    }
} 