package com.example.pattern.user.model;

import com.example.pattern.user.entity.Member;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GoogleUser implements OauthUser {
    private String name;
    private String id;

    @Override
    public Member getMember() {
        return new Member(null, name, id + "@gmail.com", "google", null, "111-222-333333");
    }

    @Override
    public String getProviderName() {
        return "Google";
    }
}
