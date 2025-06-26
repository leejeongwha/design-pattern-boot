package com.example.pattern.kiosk.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class OrderDecoratorTest {
    
    @Test
    void 데코레이터패턴_기본_테스트() {
        // 1. 기본 주문 (ConcreteComponent)
        Order basicOrder = new OrderImpl();
        log.info("=== 기본 주문 ===");
        basicOrder.command();
        
        log.info("--------------------");
        
        // 2. 배송 기능 추가 (Decorator)
        Order deliveryOrder = new Delivery(basicOrder);
        log.info("=== 배송 기능 추가 ===");
        deliveryOrder.command();
        
        log.info("--------------------");
        
        // 3. 결제 기능 추가 (Decorator)
        Order paymentOrder = new Payment(deliveryOrder);
        log.info("=== 결제 기능 추가 ===");
        paymentOrder.command();

        Assertions.assertTrue(true);
    }
}