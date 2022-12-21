package com.example.pattern.benefit.service.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BenefitItem {
    private String name;
    private String description;
    private Integer price;
}
