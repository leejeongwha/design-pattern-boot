package com.example.pattern.config;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.context.annotation.Configuration;

import com.example.pattern.order.service.OrderService;

@Configuration
public class ProxyConfig {
    //    @Bean
//    @Primary
    public OrderService orderServiceProxy() {
        return (OrderService) createCGLibProxy(OrderService.class, new MethodCallLogInterceptor());
    }

    private Object createCGLibProxy(Class<? extends Object> targetClass, MethodInterceptor interceptor) {
        // Create the proxy
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        enhancer.setCallback(interceptor);
        return enhancer.create();
    }
}
