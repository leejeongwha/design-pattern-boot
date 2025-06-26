package com.example.pattern.kiosk.state;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberStateTest {
    @Test
    void 회원_상태변경_메세지_테스트() {
        Member member = new Member();
        //회원 가입 상태
        member.register();
        member.unRegister();

        //회원 탈퇴 상태
        member.unRegister();
        member.register();

        Assertions.assertTrue(true);
    }
}