package com.example.pattern.benefit.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pattern.benefit.service.CouponItems;
import com.example.pattern.benefit.service.PointCardItems;
import com.example.pattern.benefit.service.model.BenefitItem;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("benefits")
@RequiredArgsConstructor
public class BenefitController {
    private final CouponItems couponMenu;
    private final PointCardItems pointCardMenu;

    /**
     * http://localhost:9000/benefits
     *
     * @return
     */
    @GetMapping
    public List<BenefitItem> benefits() {
        List<BenefitItem> result = new ArrayList<>();
        
        // 반복자 패턴을 사용하여 모든 혜택을 수집
        collectBenefits(couponMenu.createIterator(), result);
        collectBenefits(pointCardMenu.createIterator(), result);
        
        return result;
    }

    private void collectBenefits(Iterator<BenefitItem> iterator, List<BenefitItem> result) {
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
    }
}
