package com.example.pattern.kiosk.state;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Registered implements MemberState {
    @Override
    public MemberState register() {
        log.info("이미 회원 가입 하셨습니다");
        return new Registered();
    }

    @Override
    public MemberState unRegister() {
        log.info("회원 탈퇴가 완료 되었습니다");
        return new UnRegistered();
    }
}
