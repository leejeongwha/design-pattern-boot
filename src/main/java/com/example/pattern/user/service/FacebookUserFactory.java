package com.example.pattern.user.service;

import com.example.pattern.user.model.FacebookUser;
import com.example.pattern.user.model.OauthUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FacebookUserFactory implements OAuthUserFactory {
    @Override
    public OauthUser getUser(String token) {
        log.info("facebook OAuth api 호출");
        log.info("name : {}, email : {}", "마크 저커버그", "test@facebook.com");
        return new FacebookUser("마크 저커버그", "test@facebook.com");
    }
}
