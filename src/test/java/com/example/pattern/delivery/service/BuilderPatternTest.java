package com.example.pattern.delivery.service;

import com.example.pattern.delivery.enumeration.VehicleType;
import com.example.pattern.order.model.OrderDto;
import org.junit.jupiter.api.Test;

public class BuilderPatternTest {
    @Test
    void Order객체_빌더패턴_테스트() {
        OrderDto order = OrderDto.builder().id(1L).vehicleType(VehicleType.SHIP)
                .address("경기도 성남시 분당구 정자동").build();
        System.out.println("order 객체 : " + order.toString());
    }

    @Test
    void Order객체_점층적생성자패턴_테스트() {
        OrderDto order = new OrderDto(1L, VehicleType.SHIP, "경기도 성남시 분당구 정자동");
        System.out.println("order 객체 : " + order.toString());
    }

    @Test
    void Order객체_자바빈즈패턴_테스트() {
        OrderDto order = new OrderDto();
        order.setId(1L);
        order.setVehicleType(VehicleType.SHIP);
        order.setAddress("경기도 성남시 분당구 정자동");
        System.out.println("order 객체 : " + order.toString());
    }
}
