package com.example.pattern.kiosk.order;

public class OrderDecorator implements Order {
    private Order order;

    OrderDecorator(Order order) {
        this.order = order;
    }

    @Override
    public void command() {
        order.command();
    }
}
