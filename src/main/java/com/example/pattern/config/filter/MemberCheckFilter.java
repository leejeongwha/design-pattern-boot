package com.example.pattern.config.filter;

import java.io.IOException;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberCheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // nothing
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("==========MemberCheckFilter 필터 시작!==========");
        String memberId = servletRequest.getParameter("memberId");
        if (StringUtils.isNotEmpty(memberId)) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        log.info("==========MemberCheckFilter 필터 종료!==========");
    }

    @Override
    public void destroy() {
        // nothing
    }
}
