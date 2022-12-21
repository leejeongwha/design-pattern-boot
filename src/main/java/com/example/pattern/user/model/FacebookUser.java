package com.example.pattern.user.model;

import com.example.pattern.user.entity.Member;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FacebookUser implements OauthUser {
    private String name;
    private String email;

    @Override
    public Member getMember() {
        return new Member(null, name, email, "facebook", null, null);
    }
}
