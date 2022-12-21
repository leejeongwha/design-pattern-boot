package com.example.pattern.mail.service;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
//@Service
//@Primary
public class MailAdapter implements MailSenderA {
    private final MailSolutionB mailSolutionB;

    @Override
    public void send(MailSolutionA.MailParam mailParam) {
        MailSolutionB.MailParam param = MailSolutionB.MailParam.builder().mailTitle(mailParam.getTitle())
                .mailBody(mailParam.getBody()).receiverEmail(mailParam.getEmail()).build();
        mailSolutionB.sendApi(param);
    }
}
