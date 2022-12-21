package com.example.pattern.payment.service;

import com.example.pattern.user.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@Slf4j
public class PaymentService {
    private PaymentMethod paymentMethod;

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void pay(BigInteger amount, Member member) {
        log.info("{} 회원의 결제 지불이 완료 되었습니다. 금액 : {}", member.getName(), amount);
    }

    /**
     * 결제 방법은 호출하는 쪽에서 자유롭게 선택 가능
     *
     * @param amount
     * @param member
     */
    public void pay1(BigInteger amount, Member member) {
        boolean valid = paymentMethod.checkValid(member);
        if (valid) {
            paymentMethod.pay(amount, member);
        } else {
            throw new RuntimeException("결제 확인이 실패하였습니다.");
        }
    }
}
