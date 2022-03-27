package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    //<Entity 클래스, PK 타입> 상속->기본적인 CRUD 메소드 자동생성
    //Entity클래스와 기본 Entity repo는 함께 위치.
    //entity클래스는 기본 repo없이 제대로 역할 불가
    //->도메인 패키지에서 함께 관리
}
