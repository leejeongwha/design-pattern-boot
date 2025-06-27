package com.example.pattern.kiosk.visit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Member silverMember = new SilverMember();
        silverMember.getBenefit(new DisCountBenefit());
        silverMember.getBenefit(new PointBenefit());

        Member goldMember = new GoldMember();
        goldMember.getBenefit(new DisCountBenefit());
        goldMember.getBenefit(new PointBenefit());

        Member vipMember = new VIPMember();
        vipMember.getBenefit(new DisCountBenefit());
        vipMember.getBenefit(new PointBenefit());

        Assertions.assertTrue(true);
    }
}