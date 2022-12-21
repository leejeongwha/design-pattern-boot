package com.example.pattern.review.controller;

import com.example.pattern.review.service.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final Map<String, Review> reviewService;

    /**
     * http://localhost:9000/reviews/photo
     */
    @GetMapping("/photo")
    public void photo() {
        reviewService.get("photoReview").review();
    }

    /**
     * http://localhost:9000/reviews/text
     */
    @GetMapping("/text")
    public void text() {
        reviewService.get("textReview").review();
    }
}
