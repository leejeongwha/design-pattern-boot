package com.example.pattern.benefit.service;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.example.pattern.benefit.service.model.BenefitItem;

public class CouponIterator implements Iterator<BenefitItem> {
    private BenefitItem[] coupons;
    private int position = 0;

    public CouponIterator(BenefitItem[] coupons) {
        this.coupons = coupons;
    }

    @Override
    public boolean hasNext() {
        return position < coupons.length && coupons[position] != null;
    }

    @Override
    public BenefitItem next() {
        if (!hasNext()) {
            throw new NoSuchElementException("더 이상 요소가 없습니다.");
        }
        
        BenefitItem item = coupons[position];
        position = position + 1;
        return item;
    }
}
