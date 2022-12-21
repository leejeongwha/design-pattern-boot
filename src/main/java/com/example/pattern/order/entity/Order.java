package com.example.pattern.order.entity;

import com.example.pattern.delivery.enumeration.VehicleType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private VehicleType vehicleType;
    private String address = "경기 성남시 분당구 대왕판교로 645번길 16 플레이뮤지엄";
    private BigInteger amount;
    private Long memberId;
}
