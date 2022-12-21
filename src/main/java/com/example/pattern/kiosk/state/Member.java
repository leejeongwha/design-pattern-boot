package com.example.pattern.kiosk.state;

public class Member {
    private MemberState memberState;

    public Member() {
        //회원 가입 상태로 초기화
        this.memberState = new Registered();
    }

    public void register() {
        this.memberState = memberState.register();
    }

    public void unRegister() {
        this.memberState = memberState.unRegister();
    }
}
