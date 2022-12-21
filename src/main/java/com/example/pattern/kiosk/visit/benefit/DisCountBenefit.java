package com.example.pattern.kiosk.visit.benefit;

import com.example.pattern.kiosk.visit.GoldMember;
import com.example.pattern.kiosk.visit.SilverMember;
import com.example.pattern.kiosk.visit.VIPMember;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DisCountBenefit implements Benefit {
    @Override
    public void getBenefit(GoldMember member) {
        log.info("골드 멤버를 위한 할인 혜택");
    }

    @Override
    public void getBenefit(VIPMember member) {
        log.info("VIP 멤버를 위한 할인 혜택");
    }

    @Override
    public void getBenefit(SilverMember member) {
        log.info("실버 멤버를 위한 할인 혜택");
    }
}
