package com.example.pattern.delivery.service;

import com.example.pattern.delivery.enumeration.VehicleType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ShipService implements VehicleService {
    @Override
    public void deliver(String address) {
        log.info("컨테이너에 담아 해상으로 배달합니다. 배송지 : {}", address);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.SHIP;
    }
}
