package com.example.practice.domain.auth.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
// 불필요한 Token import 제거

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorizationUtils {

    public static String getAccessToken(String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer "))
            return authHeader.substring(7);
        throw new IllegalArgumentException("토큰에 문제가 있습니다.");
    }
}