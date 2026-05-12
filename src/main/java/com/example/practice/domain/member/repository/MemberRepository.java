package com.example.practice.domain.member.repository;

import com.example.practice.domain.member.entity.MemberEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;


@Repository
public class MemberRepository {
    // ConcurrentHashMap은 멀티 스레드 환경에서 여러 요청이 동시에 접근해도 데이터가 꼬이지 않도록,
    // 맵 전체가 아닌 개별 버킷(구역) 단위로만 잠금(Lock)을 걸어 데이터 안전성과 처리 속도를 동시에 잡아낸 자료구조입니다.
    private static Map<Long, MemberEntity> memberStore = new ConcurrentHashMap<>();

    public MemberEntity save(MemberEntity entity) {
        memberStore.put(entity.getId(), entity);
        MemberEntity savedEntity = memberStore.get(entity.getId());

        return savedEntity;
    }

    public Optional<MemberEntity> findByLoginId(String loginId){
        for(MemberEntity entity: memberStore.values()){
            if(entity.getLoginId().equals(loginId))
                return Optional.of(entity);
        }
        return Optional.empty();
    }

    public Optional<MemberEntity> findById(Long memberId) {
        return Optional.ofNullable(memberStore.get(memberId));
    }
}
