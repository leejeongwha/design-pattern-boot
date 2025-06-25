package com.example.pattern.payment.service;

import java.math.BigInteger;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.pattern.user.entity.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {
    
    private final Map<String, PaymentMethod> paymentMethods;

    /**
     * Bridge 패턴을 사용한 결제 처리
     * 추상화 계층과 구현 계층이 분리되어 독립적으로 확장 가능
     */
    public void processPayment(String paymentMode, BigInteger amount, Member member) {
        PaymentMethod method = !StringUtils.isEmpty(member.getAccountNumber()) ? paymentMethods.get("cardMethodService") : paymentMethods.get("phoneMethodService");
        PaymentAbstraction abstraction = getPaymentAbstraction(paymentMode, method);
        
        abstraction.pay(amount, member);
    }

    private PaymentAbstraction getPaymentAbstraction(String paymentMode, PaymentMethod method) {
        return switch (paymentMode.toLowerCase()) {
            case "online" -> new OnlinePayment(method);
            case "offline" -> new OfflinePayment(method);
            default -> throw new IllegalArgumentException("지원하지 않는 결제 모드입니다: " + paymentMode);
        };
    }

    /**
     * 기존 호환성을 위한 메서드 (점진적 마이그레이션)
     */
    public void pay(BigInteger amount, Member member) {
        log.info("{} 회원의 결제 지불이 완료 되었습니다. 금액 : {}", member.getName(), amount);
    }
}
