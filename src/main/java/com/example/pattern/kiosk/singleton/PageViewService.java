package com.example.pattern.kiosk.singleton;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Service
@Getter
@Slf4j
public class PageViewService {
    private int increment = 0;

    public void incr() {
        log.info("누적 방문자 : " + increment);
        increment++;
    }
}
