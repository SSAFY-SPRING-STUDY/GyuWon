package com.example.practice.domain.auth.controller.dto;

public record LoginRequest(
    String loginId,
    String password
) {
}
