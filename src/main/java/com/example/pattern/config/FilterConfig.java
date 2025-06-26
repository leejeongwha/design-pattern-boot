package com.example.pattern.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

import com.example.pattern.config.filter.MemberCheckFilter;
import com.example.pattern.config.filter.UserAgentCheckFilter;

@Configuration
public class FilterConfig {
    //    @Bean
//    @Order(0)
    public FilterRegistrationBean<UserAgentCheckFilter> userAgentCheckFilter() {
        FilterRegistrationBean<UserAgentCheckFilter> registrationBean = new FilterRegistrationBean<>(new UserAgentCheckFilter());
        registrationBean.addUrlPatterns("/orders/*");
        return registrationBean;
    }

    //    @Bean
//    @Order(1)
    public FilterRegistrationBean<MemberCheckFilter> memberCheckFilter() {
        FilterRegistrationBean<MemberCheckFilter> registrationBean = new FilterRegistrationBean<>(new MemberCheckFilter());
        registrationBean.addUrlPatterns("/orders/*");
        return registrationBean;
    }
}
