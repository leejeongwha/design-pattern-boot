package com.example.pattern.delivery.service;

import com.example.pattern.delivery.enumeration.VehicleType;

public interface VehicleService {
    void deliver(String address);

    VehicleType getType();
}
