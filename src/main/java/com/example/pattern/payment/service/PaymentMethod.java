package com.example.pattern.payment.service;

import com.example.pattern.user.entity.Member;

import java.math.BigInteger;

public interface PaymentMethod {
    boolean checkValid(Member member);

    void pay(BigInteger amount, Member member);
}
