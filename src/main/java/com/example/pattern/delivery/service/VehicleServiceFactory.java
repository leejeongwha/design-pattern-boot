package com.example.pattern.delivery.service;

import com.example.pattern.delivery.enumeration.VehicleType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class VehicleServiceFactory {
    private final Map<String, VehicleService> deliveryService;

    public VehicleService getService(VehicleType type) {
        VehicleService service = switch (type) {
            case TRUCK -> deliveryService.get("truckService");
            case SHIP -> deliveryService.get("shipService");
        };

        return service;
    }
}
