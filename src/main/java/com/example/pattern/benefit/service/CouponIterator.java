package com.example.pattern.benefit.service;

import com.example.pattern.benefit.service.model.BenefitItem;

import java.util.Iterator;

public class CouponIterator implements Iterator {
    private BenefitItem[] coupons;
    private int position = 0;

    public CouponIterator(BenefitItem[] coupons) {
        this.coupons = coupons;
    }

    @Override
    public boolean hasNext() {
        if (position >= coupons.length || coupons[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public BenefitItem next() {
        BenefitItem item = coupons[position];
        position = position + 1;
        return item;
    }
}
