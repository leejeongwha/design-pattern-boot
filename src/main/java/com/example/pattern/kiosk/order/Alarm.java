package com.example.pattern.kiosk.order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Alarm extends OrderDecorator {
    Alarm(Order order) {
        super(order);
    }

    @Override
    public void command() {
        super.command();
        alarm();
    }

    private void alarm() {
        log.info("알림 방식이 추가되었습니다.");
    }
}
