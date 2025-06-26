package com.example.pattern.delivery.service;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.pattern.delivery.enumeration.VehicleType;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class VehicleServiceFactory {
    private final Map<String, VehicleService> deliveryService;

    public VehicleService getService(VehicleType type) {
        return switch (type) {
            case TRUCK -> deliveryService.get("truckService");
            case SHIP -> deliveryService.get("shipService");
        };
    }
}
