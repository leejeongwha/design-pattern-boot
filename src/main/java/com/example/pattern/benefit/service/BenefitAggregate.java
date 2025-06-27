package com.example.pattern.benefit.service;

import java.util.Iterator;

import com.example.pattern.benefit.service.model.BenefitItem;

public interface BenefitAggregate {
    Iterator<BenefitItem> createIterator();
        
}
