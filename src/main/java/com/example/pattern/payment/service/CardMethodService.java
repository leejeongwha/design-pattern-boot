package com.example.pattern.payment.service;

import com.example.pattern.user.entity.Member;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

@Slf4j
public class CardMethodService implements PaymentMethod {
    @Override
    public boolean checkValid(Member member) {
        log.info("{} 회원님의 카드 확인이 완료 되었습니다. 계좌번호 : {}", member.getName(), member.getAccountNumber());
        return true;
    }

    @Override
    public void pay(BigInteger amount, Member member) {
        log.info("{} 회원님의 카드 결제 지불이 완료 되었습니다. 금액 : {}", member.getName(), amount);
    }
}
