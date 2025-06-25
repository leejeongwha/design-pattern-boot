package com.example.pattern.user.service;

import org.springframework.stereotype.Component;

import com.example.pattern.user.model.GoogleProfile;
import com.example.pattern.user.model.GoogleUser;
import com.example.pattern.user.model.OAuthProfile;
import com.example.pattern.user.model.OauthUser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GoogleOAuthFactory implements OAuthAbstractFactory {
    
    @Override
    public OauthUser createUser(String token) {
        log.info("Google OAuth API 호출하여 사용자 생성");
        return new GoogleUser("래리 페이지", "test");
    }
    
    @Override
    public OAuthProfile createProfile(String token) {
        log.info("Google 프로필 정보 생성");
        return new GoogleProfile("래리 페이지", "test@gmail.com", "https://google.com/larry.jpg");
    }
    
    @Override
    public String getProviderName() {
        return "Google";
    }
} 