package com.example.pattern.user.service;

import org.springframework.stereotype.Component;

import com.example.pattern.user.model.FacebookProfile;
import com.example.pattern.user.model.FacebookUser;
import com.example.pattern.user.model.OAuthProfile;
import com.example.pattern.user.model.OauthUser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FacebookOAuthFactory implements OAuthAbstractFactory {
    
    @Override
    public OauthUser createUser(String token) {
        log.info("Facebook OAuth API 호출하여 사용자 생성");
        return new FacebookUser("마크 저커버그", "test@facebook.com");
    }
    
    @Override
    public OAuthProfile createProfile(String token) {
        log.info("Facebook 프로필 정보 생성");
        return new FacebookProfile("마크 저커버그", "test@facebook.com", "https://facebook.com/mark.jpg");
    }
    
    @Override
    public String getProviderName() {
        return "Facebook";
    }
} 