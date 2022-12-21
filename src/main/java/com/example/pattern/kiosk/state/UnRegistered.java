package com.example.pattern.kiosk.state;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UnRegistered implements MemberState {
    @Override
    public MemberState register() {
        log.info("회원 가입이 완료 되었습니다");
        return new Registered();
    }

    @Override
    public MemberState unRegister() {
        log.info("현재 회원 가입 상태가 아닙니다.");
        return new UnRegistered();
    }
}
