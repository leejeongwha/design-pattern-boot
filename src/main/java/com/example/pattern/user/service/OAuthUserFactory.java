package com.example.pattern.user.service;

import com.example.pattern.user.model.OauthUser;

public interface OAuthUserFactory {
    OauthUser getUser(String token);
}
