package com.example.pattern.payment.service;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import com.example.pattern.user.entity.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CardMethodService implements PaymentMethod {
    @Override
    public boolean validatePayment(Member member) {
        log.info("카드 결제 검증: {} 회원님의 카드 확인이 완료되었습니다. 계좌번호: {}", 
                member.getName(), member.getAccountNumber());
        return true;
    }

    @Override
    public void processPayment(BigInteger amount, Member member) {
        log.info("카드 결제 처리: {} 회원님의 카드 결제가 완료되었습니다. 금액: {}", 
                member.getName(), amount);
    }

    @Override
    public String getPaymentType() {
        return "CARD";
    }
}
