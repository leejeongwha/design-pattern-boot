package com.example.pattern.kiosk.singleton;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class PageViewService {
    private int increment = 0;

    public void incr() {
        System.out.println("누적 방문자 : " + increment);
        increment++;
    }
}
