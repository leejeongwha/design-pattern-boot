package com.example.pattern.config;

import com.example.pattern.order.service.OrderService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.objenesis.SpringObjenesis;

@Configuration
public class ProxyConfig {
    private final SpringObjenesis objenesis = new SpringObjenesis();

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
