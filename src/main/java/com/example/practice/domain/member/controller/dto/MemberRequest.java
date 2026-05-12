package com.example.practice.domain.member.controller.dto;

import com.example.practice.domain.member.entity.MemberEntity;

//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//
//@Getter
//@RequiredArgsConstructor가 기본적으로 내장 되어있다! 이건 레코드이기 때문
public record MemberRequest(
        String loginId,
        String password,
        String name

        // MemberRequest request가 있다고 치면
        // request.getLoginId() X
        // request.loginId() O -> getter가 내장 되어있음
) {

    public static MemberEntity toEntity(MemberRequest request) {
        return new MemberEntity(
                request.loginId(),
                request.password(),
                request.name()
        );
    }
}