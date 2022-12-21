package com.example.pattern.order.controller;

import com.example.pattern.order.entity.Order;
import com.example.pattern.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController {
    private final OrderService orderService;
    private final ApplicationEventPublisher eventPublisher;

    /**
     * http://localhost:9000/orders?vehicleType=SHIP&memberId=1&amount=20000&id=1
     * <p>
     * 주문 시작
     *
     * @param order
     */
    @GetMapping
    public void order(Order order) {
        orderService.order(order);

        //eventPublisher.publishEvent(new OrderEvent(order.getId(), OrderType.CREATE));
    }
}
