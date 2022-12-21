package com.example.pattern.benefit.service;

import com.example.pattern.benefit.service.model.BenefitItem;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PointCardMenu {
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
}
