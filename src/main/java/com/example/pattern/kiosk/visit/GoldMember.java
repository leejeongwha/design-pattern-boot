package com.example.pattern.kiosk.visit;

import com.example.pattern.kiosk.visit.benefit.Benefit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GoldMember implements Member {
    public void point() {
        log.info("골드 멤버를 위한 포인트 제공 혜택");
    }

    public void discount() {
        log.info("골드 멤버를 위한 할인 혜택");
    }


    @Override
    public void getBenefit(Benefit benefit) {
        benefit.getBenefit(this);
    }
}
