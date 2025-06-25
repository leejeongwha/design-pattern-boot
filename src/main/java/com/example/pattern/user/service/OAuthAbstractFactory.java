package com.example.pattern.user.service;

import com.example.pattern.user.model.OAuthProfile;
import com.example.pattern.user.model.OauthUser;

public interface OAuthAbstractFactory {
    OauthUser createUser(String token);
    OAuthProfile createProfile(String token);
    String getProviderName();
} 