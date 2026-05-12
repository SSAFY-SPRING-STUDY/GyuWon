package com.example.practice.domain.post.controller;

import com.example.practice.domain.post.controller.dto.PostRequest;
import com.example.practice.domain.post.controller.dto.PostResponse;
import com.example.practice.domain.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping("/api/posts")
    public PostResponse createPost(@RequestBody PostRequest request){
        PostResponse response = postService.save(request);

        return response;
    }

    @GetMapping("/api/posts")
    public List<PostResponse> findAllPosts(){
        return postService.findAll();
    }

    @GetMapping("/api/posts/{id}")
    public PostResponse findPostById(@PathVariable Long id){
        PostResponse response = postService.findById(id);
        return response;

    }
}
