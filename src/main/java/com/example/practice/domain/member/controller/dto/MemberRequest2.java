package com.example.practice.domain.member.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class MemberRequest2{
        private final String loginId;
        private final String password;
        private final String name;
}
