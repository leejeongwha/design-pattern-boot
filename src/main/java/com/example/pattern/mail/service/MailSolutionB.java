package com.example.pattern.mail.service;

import com.example.pattern.mail.service.MailSenderB;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailSolutionB implements MailSenderB {

    @Override
    public void sendApi(MailParam mailParam) {
        log.info("B 솔루션 회사에서 메일 발송");
    }

    @Builder
    public static class MailParam {
        private String mailTitle;
        private String mailBody;
        private String receiverEmail;
    }
}
