package com.example.pattern.review.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PhotoReview extends Review {
    @Override
    public void putContent() {
        log.info("사진을 등록 하였습니다.");
    }
}
