package com.example.pattern.user.controller;

import com.example.pattern.user.entity.Member;
import com.example.pattern.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    /**
     * http://localhost:9000/members/enroll?snsType=facebook&token=123
     *
     * @param snsType
     * @param token
     */
    @GetMapping("enroll")
    public Member enroll(String snsType, String token) {
        Member member = memberService.saveMember(snsType, token);

        member.setSnsType("kakao");
        memberService.emptyLogic();
        return member;
    }
}
