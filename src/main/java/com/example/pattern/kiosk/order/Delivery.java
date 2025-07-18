package com.example.pattern.kiosk.order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Delivery extends OrderDecorator {
    Delivery(Order order) {
        super(order);
    }

    @Override
    public void command() {
        super.command();
        delivery();
    }

    private void delivery() {
        log.info("배송을 시작합니다.");
    }
}
