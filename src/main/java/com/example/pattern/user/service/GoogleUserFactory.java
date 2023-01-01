package com.example.pattern.user.service;

import com.example.pattern.user.model.GoogleUser;
import com.example.pattern.user.model.OauthUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GoogleUserFactory implements OAuthUserFactory {
    @Override
    public OauthUser getUser(String token) {
        log.info("google OAuth api 호출");
        log.info("name : {}, id : {}", "래리 페이지", "test");
        return new GoogleUser("래리 페이지", "test");
    }
}
