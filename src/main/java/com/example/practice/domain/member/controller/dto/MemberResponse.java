package com.example.practice.domain.member.controller.dto;

import com.example.practice.domain.member.entity.MemberEntity;

public record MemberResponse(
        Long id,
        String password,
        String name
) {

    public static MemberResponse fromEntity(MemberEntity entity){
        return new MemberResponse(
                entity.getId(),
                entity.getLoginId(),
                entity.getName()
        );
    }
}