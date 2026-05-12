package com.example.practice.domain.auth.controller;


import com.example.practice.domain.auth.controller.dto.LoginRequest;
import com.example.practice.domain.auth.controller.dto.LoginResponse;
import com.example.practice.domain.auth.service.AuthService;
import com.example.practice.domain.auth.util.AuthorizationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")

public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        LoginResponse response = null;
        try{
            response = authService.login(request);
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String authHeader){
        // authHeader = "token"만 받아오는게 아니라 ..
        // authHeader = "BEARER" "salda;sdla;ada" 토큰이 있는지 검사 .. -> 번거로움 -> 파싱을 해서 가져오는 메서드 -> 유틸
        String accessToken = AuthorizationUtils.getAccessToken(authHeader);
        authService.logout(accessToken);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
