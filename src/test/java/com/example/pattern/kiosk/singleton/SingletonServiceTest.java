package com.example.pattern.kiosk.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SingletonServiceTest {
    @Test
    void 싱글톤패턴_객체테스트() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        //참조값이 같은 것을 확인
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        // singletonService1 == singletonService2
        Assertions.assertEquals(singletonService1, singletonService2);
    }
}