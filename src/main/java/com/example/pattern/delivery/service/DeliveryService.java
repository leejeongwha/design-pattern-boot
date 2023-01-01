package com.example.pattern.delivery.service;

import com.example.pattern.delivery.enumeration.VehicleType;
import com.example.pattern.order.entity.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeliveryService {
    /**
     * 외부에서 들어오는 vehicleType 마다 일일이 if,else 혹은 swith를 이용해서 구현해 주어야 함
     * 새로운 배송 방법이 추가될 때마다 구현코드가 복잡해 짐
     *
     * @param order
     */
    public void deliver0(Order order) {
        if (order.getVehicleType() == VehicleType.TRUCK) {
            log.info("상자에 담아 육로로 배달 합니다. 배송지 : {}", order.getAddress());
        } else if (order.getVehicleType() == VehicleType.SHIP) {
            log.info("컨테이너에 담아 해상으로 배달합니다. 배송지 : {}", order.getAddress());
        } else {
            throw new IllegalArgumentException("존재하는 배송 방법이 없습니다.");
        }
    }

    private final TruckService truckService;
    private final ShipService shipService;

    /**
     * 새로운 배송 방법이 추가될 경우 VehicleService를 구현한 구현체만 생성하면 됨
     * 하지만 팩토리 메서드 패턴을 사용하지 않았을 경우 타입마다 일일이 다른 bean을 주입받아서 사용해야 한다
     * 여전히 truckService 및 shipService와 강하게 결합되어 있다
     *
     * @param order
     */
    public void deliver1(Order order) {
        switch (order.getVehicleType()) {
            case TRUCK -> truckService.deliver(order.getAddress());
            case SHIP -> shipService.deliver(order.getAddress());
            default -> throw new IllegalArgumentException("존재하는 배송 방법이 없습니다.");
        }
    }

    private final VehicleServiceFactory vehicleServiceFactory;

    /**
     * 생성에 대한 책임을 Factory 클래스로 위임하여 강하게 결합되어 있는 부분을 제거
     *
     * @param order
     */
    public void deliver(Order order) {
        VehicleService service = vehicleServiceFactory.getService(order.getVehicleType());
        service.deliver(order.getAddress());
    }
}
