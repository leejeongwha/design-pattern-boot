package com.example.pattern.review.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Review {
    public void review() {
        //부모 클래스에서 알고리즘의 골격을 정의
        login();
        selectBooks();
        putContent();
        selectEvaluation();
    }

    public void login() {
        log.info("로그인 성공!");
    }

    public void selectBooks() {
        log.info("리뷰 대상 상품 선택");
    }

    public void selectEvaluation() {
        log.info("별점 선택");
    }

    public abstract void putContent();

}
