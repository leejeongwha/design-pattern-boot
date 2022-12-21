package com.example.pattern.order.model;

import com.example.pattern.delivery.enumeration.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    private Long id;
    private VehicleType vehicleType;
    @Builder.Default
    private String address = "경기 성남시 분당구 대왕판교로 645번길 16 플레이뮤지엄";
}
