package com.example.pattern.kiosk.order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Payment extends OrderDecorator {
    Payment(Order order) {
        super(order);
    }

    @Override
    public void command() {
        super.command();
        pay();
    }

    private void pay() {
        log.info("결제 기능이 추가되었습니다.");
    }
}
