package com.example.practice.domain.post.controller.dto;

import lombok.Getter;

// 불변성 보장으로 get -> 값을 조회하는 메서드
// set은 값을 변경.. setter를 쓰면 값을 바꿀 수 있으니 불변성 보장 안되므로 getter만 사용한다.

@Getter
public class PostResponse {
    private final long id; // 게시글 번호 (DB 자동 생성, 사용자 입력 X)
    private final String title;
    private final String content;
    private final String author;

    public PostResponse(long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
