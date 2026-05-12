package com.example.practice.domain.post.service;

import com.example.practice.domain.post.controller.dto.PostRequest;
import com.example.practice.domain.post.controller.dto.PostResponse;
import com.example.practice.domain.post.PostEntity;
import com.example.practice.domain.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public PostResponse save(PostRequest request) {
        PostEntity entity = new PostEntity(request.getTitle(), request.getContent(), request.getAuthor());
        PostEntity returnedEntity = postRepository.save(entity);

        PostResponse response = new PostResponse(
                returnedEntity.getId(),
                returnedEntity.getTitle(),
                returnedEntity.getContent(),
                returnedEntity.getAuthor());

        return response;
    }

    public List<PostResponse> findAll(){
        List<PostEntity> entityList = postRepository.findAll();
        List<PostResponse> responseList = new ArrayList<>();

        for(PostEntity entity : entityList){
            PostResponse response = new PostResponse(
                    entity.getId(),
                    entity.getTitle(),
                    entity.getContent(),
                    entity.getAuthor());
            responseList.add(response);
        }
        return responseList;
    }

    // 1. 단건 조회 (ID로 찾기)
    public PostResponse findById(Long id) {
        // DB에서 해당 ID를 찾고, 없으면 예외를 발생시킵니다.
        PostEntity entity = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id=" + id));

        return new PostResponse(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getAuthor());
    }

    // 2. 게시글 삭제
    public void delete(Long id) {
        // 삭제할 대상이 있는지 먼저 확인합니다.
        PostEntity entity = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id=" + id));

        postRepository.delete(entity);
    }
}