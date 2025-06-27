package com.example.pattern.kiosk.visit;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.pattern.kiosk.visit.benefit.Benefit;
import com.example.pattern.kiosk.visit.benefit.DisCountBenefit;
import com.example.pattern.kiosk.visit.benefit.PointBenefit;

class BenefitTest {
    /**
     * 기존 방식 테스트
     * 각 멤버 클래스에 직접 접근하여 메서드 호출하는 방식
     */
    @Test
    void 기존_방식_테스트() {
        GoldMember goldMember = new GoldMember();
        goldMember.point();
        goldMember.discount();

        Assertions.assertTrue(true);
    }

    /**
     * 방문자 패턴 적용 테스트
     * 새로운 혜택 타입을 쉽게 추가할 수 있음 (새로운 Benefit 구현체를 만들면 됨)
     */
    @Test
    void 방문자_패턴_테스트() {
        // 멤버들과 혜택들 생성
        List<Member> members = List.of(new SilverMember(), new GoldMember(), new VIPMember());
        List<Benefit> benefits = List.of(new DisCountBenefit(), new PointBenefit());

        // 모든 멤버에게 모든 혜택 적용
        for (Member member : members) {
            for (Benefit benefit : benefits) {
                member.getBenefit(benefit);
            }
        }

        Assertions.assertTrue(true);
    }
}