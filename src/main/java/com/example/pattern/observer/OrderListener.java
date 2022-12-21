package com.example.pattern.observer;

import com.example.pattern.order.model.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Async
public class OrderListener {
    @EventListener
    public void onApplicationEvent(OrderEvent event) {
        log.info("주문이벤트 Published [orderId : {}, orderType : {}]", event.getOrderId(), event.getOrderType().toString());
        log.info("이후 리뷰 알림 발송이 시작됩니다.");
        log.info("이후 정산 API 호출이 시작됩니다.");
    }
}
