package com.example.practice.domain.member.entity;

import lombok.Getter;

// 엔티티는 수정 가능성이 있어서 final로 작성 안함
// dto는 final로 작성함 -> 완전 불변하므로 레코드로 작성
@Getter
public class MemberEntity {
    private static Long AUTO_INCREMENT = 1L;

    private Long id;
    private String loginId;
    private String password;
    private String name;

    public MemberEntity(String loginId, String password, String name){
        this.id = AUTO_INCREMENT++;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
    }

    public boolean isValidPassword(String password){
        return this.password.equals(password);
    }
}