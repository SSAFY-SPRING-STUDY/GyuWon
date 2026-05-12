package com.example.practice.domain.auth.service;

import com.example.practice.domain.auth.component.SessionManager;
import com.example.practice.domain.auth.controller.dto.LoginRequest;
import com.example.practice.domain.auth.controller.dto.LoginResponse;
import com.example.practice.domain.member.entity.MemberEntity;
import com.example.practice.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final SessionManager sessionManager;
    private final MemberRepository memberRepository;

    public LoginResponse login(LoginRequest request) {
        MemberEntity member = memberRepository.findByLoginId(request.loginId())
                .orElseThrow(() -> new RuntimeException("아이디가 올바르지 않습니다."));

        if(member.isValidPassword(request.password())){
            String token = sessionManager.createSession(member.getId()); // 토큰값 받아오기
            return new LoginResponse(token, "BEARER");

        }
        throw new RuntimeException("비밀번호가 올바르지 않습니다.");
    }

    public void logout(String accessToken) {
        sessionManager.removeSession(accessToken);
    }

    public Long getMemberId(String accessToken) {
        return sessionManager.getMemberId(accessToken).orElseThrow(
                () -> new RuntimeException("id값 조회 불가")
        );
    }
}
