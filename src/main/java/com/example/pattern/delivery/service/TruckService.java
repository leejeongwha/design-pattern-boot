package com.example.pattern.delivery.service;

import com.example.pattern.delivery.enumeration.VehicleType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TruckService implements VehicleService {
    @Override
    public void deliver(String address) {
        log.info("상자에 담아 육로로 배달 합니다. 배송지 : {}", address);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }
}
