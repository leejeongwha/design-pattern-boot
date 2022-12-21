package com.example.pattern.config.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class UserAgentCheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("==========UserAgentCheckFilter 필터 시작!==========");
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String userAgent = httpRequest.getHeader("user-agent");
        log.info("user agent : " + userAgent);
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("==========UserAgentCheckFilter 필터 종료!==========");
    }

    @Override
    public void destroy() {
    }
}
