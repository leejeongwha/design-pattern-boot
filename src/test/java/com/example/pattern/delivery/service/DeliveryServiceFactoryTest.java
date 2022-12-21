package com.example.pattern.delivery.service;

import com.example.pattern.delivery.enumeration.VehicleType;
import com.example.pattern.order.entity.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DeliveryServiceFactoryTest {
    @Autowired
    private VehicleServiceFactory deliveryServiceFactory;

    @Test
    void 운송수단별로_서비스_가져오기() {
        //given
        VehicleType truck = VehicleType.TRUCK;
        VehicleType ship = VehicleType.SHIP;

        //when
        VehicleService truckService = deliveryServiceFactory.getService(truck);
        VehicleService shipService = deliveryServiceFactory.getService(ship);

        //then
        Assertions.assertEquals(truckService.getType(), truck);
        Assertions.assertEquals(shipService.getType(), ship);

        //print
        truckService.deliver(new Order().getAddress());
        shipService.deliver(new Order().getAddress());
    }
}