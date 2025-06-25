package com.example.pattern.user.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GoogleProfile implements OAuthProfile {
    private String name;
    private String email;
    private String profileImageUrl;
    
    @Override
    public String getProfileImage() {
        return profileImageUrl != null ? profileImageUrl : "https://google.com/default-avatar.png";
    }
    
    @Override
    public String getDisplayName() {
        return name;
    }
    
    @Override
    public String getEmail() {
        return email;
    }
    
    @Override
    public String getProviderName() {
        return "Google";
    }
} 