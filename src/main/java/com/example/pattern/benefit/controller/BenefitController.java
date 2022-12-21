package com.example.pattern.benefit.controller;

import com.example.pattern.benefit.service.CouponMenu;
import com.example.pattern.benefit.service.PointCardMenu;
import com.example.pattern.benefit.service.model.BenefitItem;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("benefits")
@RequiredArgsConstructor
public class BenefitController {
    private final CouponMenu couponMenu;
    private final PointCardMenu pointCardMenu;

    /**
     * http://localhost:9000/benefits
     *
     * @return
     */
    @GetMapping
    public List<BenefitItem> benefits() {
//        List<BenefitItem> result = new ArrayList<>();
//
//        BenefitItem[] coupons = couponMenu.getItems();
//        List<BenefitItem> pointCards = pointCardMenu.getItems();
//
//        result.addAll(pointCards);
//        result.addAll(Arrays.asList(coupons));

        List<BenefitItem> result = new ArrayList<>();
        result.addAll(addItem(couponMenu.createIterator()));
        result.addAll(addItem(pointCardMenu.getItems().iterator()));

        return result;
    }

    private List<BenefitItem> addItem(Iterator iterator) {
        List<BenefitItem> result = new ArrayList<>();
        while (iterator.hasNext()) {
            BenefitItem item = (BenefitItem) iterator.next();
            result.add(item);
        }
        return result;
    }
}
