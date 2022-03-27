package com.jojoldu.book.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application { //앞으로 만들 프로젝트의 메인 클래스
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        //Web Application Server = WAS -> 내장 WAS는 톰캣이 필요 없고 앱 실행시 내부에서 WAS실행하는것
        //내장 was를 사용- 언제 어디서나 같은 환경에서 스트링 부트 배포가능
        //내장 쓰면 모든 서버의 종류 버전 설정을 일치 시키지 않아도됨
    }
}
