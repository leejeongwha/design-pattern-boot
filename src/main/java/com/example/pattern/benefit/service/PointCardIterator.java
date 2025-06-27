package com.example.pattern.benefit.service;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.pattern.benefit.service.model.BenefitItem;

public class PointCardIterator implements Iterator<BenefitItem> {
    private List<BenefitItem> items;
    private int position = 0;

    public PointCardIterator(List<BenefitItem> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public BenefitItem next() {
        if (!hasNext()) {
            throw new NoSuchElementException("더 이상 요소가 없습니다.");
        }
        
        BenefitItem item = items.get(position);
        position = position + 1;
        return item;
    }
} 