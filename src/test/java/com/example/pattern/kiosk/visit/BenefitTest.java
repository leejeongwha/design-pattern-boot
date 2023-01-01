package com.example.pattern.kiosk.visit;

import org.junit.jupiter.api.Test;

class BenefitTest {
    @Test
    void 멤버_등급별_혜택_테스트() {
        //기존 코드
        GoldMember goldMember = new GoldMember();
        goldMember.point();
        goldMember.discount();

        //방문자 패턴을 적용한 코드
//        Member silverMember = new SilverMember();
//        silverMember.getBenefit(new DisCountBenefit());
//        silverMember.getBenefit(new PointBenefit());
//
//        Member goldMember = new GoldMember();
//        goldMember.getBenefit(new DisCountBenefit());
//        silverMember.getBenefit(new PointBenefit());
//
//        VIPMember vipMember = new VIPMember();
//        vipMember.getBenefit(new DisCountBenefit());
//        vipMember.getBenefit(new PointBenefit());
    }
}