package com.example.pattern.kiosk.order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderImpl implements Order {

    @Override
    public void command() {
        log.info("주문이 시작되었습니다.");
    }
}
