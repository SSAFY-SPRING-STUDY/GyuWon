package com.example.practice.domain.post.repository;

import com.example.practice.domain.post.PostEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {
    List<PostEntity> postList = new ArrayList<>();

    public PostEntity save(PostEntity postEntity){
        postList.add(postEntity);

        return postEntity;
    }

    public List<PostEntity> findAll(){
        return postList;
    }


    // 리턴문을 쓸 때 객체를 제외한 나머지는 돌려줄 수 없는게 단점
    // 포괄적으로 쓰기 위한.. 상태코드를 위한 responseEntity
    public Optional<PostEntity> findById(Long id) {
        // 리스트를 돌면서 ID가 일치하는 게시글을 찾습니다.
        return postList.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst();
    }

    // 게시글 삭제 기능 추가
    public void delete(PostEntity entity) {
        postList.remove(entity);
    }
}
