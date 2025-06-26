package com.example.pattern.benefit.service;

import java.util.Iterator;

import org.springframework.stereotype.Service;

import com.example.pattern.benefit.service.model.BenefitItem;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CouponMenu {
    private BenefitItem[] coupons = new BenefitItem[10];
    private int position = 0;


    public void add(String name, String description, Integer price) {
        if (position < 9) {
            coupons[position] = BenefitItem.builder().name(name).description(description).price(price).build();
            position = position + 1;
        } else {
            log.info("더 이상 추가할 수 없습니다.");
        }
    }

    public BenefitItem[] getItems() {
        return coupons;
    }

    @PostConstruct
    public void postConstruct() {
        add("첫구매쿠폰", "첫구매쿠폰", 3000);
        add("생일쿠폰", "생일쿠폰", 5000);
    }

    public Iterator<BenefitItem> createIterator() {
        return new CouponIterator(coupons);
    }
}
