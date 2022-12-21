package com.example.pattern.user.model;

import lombok.Data;

@Data
public class MemberDto {
    private Long id;
    private String name;
    private String email;
    private String snsType;
}
