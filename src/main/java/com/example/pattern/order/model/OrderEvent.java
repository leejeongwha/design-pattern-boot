package com.example.pattern.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderEvent {
    private Long orderId;
    private OrderType orderType;
}
