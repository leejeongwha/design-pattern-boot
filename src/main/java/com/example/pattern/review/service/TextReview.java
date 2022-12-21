package com.example.pattern.review.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TextReview extends Review {
    @Override
    public void putContent() {
        log.info("한줄 리뷰를 작성 하였습니다.");
    }
}
