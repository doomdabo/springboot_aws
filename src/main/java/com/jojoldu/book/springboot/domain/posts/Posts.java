package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //기본생성자 자동추가
@Entity //테이블과 링크될 클래스임을 나타냄 -> setter있으면 해당 클래스의 인스턴스 값들이 언제 어디서 변해야하는지 코드상으로
//명확하게 구분 불가-> 변경 복잡!-->  entity에는 절대 setter 메소드 안만듦
public class Posts extends BaseTimeEntity {
    @Id//해당 테이블의 pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)//pk생성 규칙->auto_increment되려면 identity추가해야함
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){ //entity 클래스
        this.title = title;
        this.content = content;
        this.author = author;

    }
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
