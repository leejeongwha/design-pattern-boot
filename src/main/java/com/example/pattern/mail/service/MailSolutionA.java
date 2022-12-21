package com.example.pattern.mail.service;

import com.example.pattern.mail.service.MailSenderA;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailSolutionA implements MailSenderA {

    @Override
    public void send(MailParam mailParam) {
        log.info("A 솔루션 회사에서 메일 발송");
    }

    @Builder
    @Getter
    public static class MailParam {
        private String title;
        private String body;
        private String email;
    }
}
