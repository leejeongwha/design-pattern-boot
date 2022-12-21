package com.example.pattern.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class MethodCallLogInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        log.info("주문에 대한 호출 기록을 남깁니다. (before)");
        Object returnValue = proxy.invokeSuper(obj, args);
        log.info("주문에 대한 호출 기록을 남깁니다. (after)");
        return returnValue;
    }
}
