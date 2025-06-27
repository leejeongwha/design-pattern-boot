package com.example.pattern.benefit.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pattern.benefit.service.model.BenefitItem;

import jakarta.annotation.PostConstruct;

@Service
public class PointCardItems {
    private List<BenefitItem> items = new ArrayList<>();


    public void add(String name, String description, Integer price) {
        items.add(BenefitItem.builder().name(name).description(description).price(price).build());
    }

    public List<BenefitItem> getItems() {
        return items;
    }

    @PostConstruct
    public void postConstruct() {
        add("3천원포인트", "3천원포인트", 3000);
        add("5천원포인트", "5천원포인트", 5000);
    }

    public Iterator<BenefitItem> createIterator() {
        return items.iterator();
    }
}
