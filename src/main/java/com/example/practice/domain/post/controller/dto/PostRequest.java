package com.example.practice.domain.post.controller.dto;

import lombok.Getter;

/**
 * DTO (Data Transfer Object): 계층 간 데이터를 안전하게 전달하는 '택배 상자'
 * * Q. Request와 Response를 왜 따로 만들까?
 * - Request: 클라이언트가 서버로 보낼 정보만 담은 '주문서' (보안 및 입력 검증용)
 * - Response: 서버가 처리를 마친 후 클라이언트에 보여줄 '결과서' (필요한 데이터만 선별 제공)
 */

@Getter
public class PostRequest
{

    private final String title;
    private final String content;
    private final String author;

    public PostRequest(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
