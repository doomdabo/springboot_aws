package com.jojoldu.book.springboot;

import com.jojoldu.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)//테스트 진행시 junit에 내장된 실행자 외 다른 실행자 실행.
// spring runner 스프링 실행자 사용
//스프링부트 테스트, junit 사이 연결자 역할
@WebMvcTest(controllers = HelloController.class)
//web에 집중할 수 있는 어노테이션.
// service, component, repository 사용 불가 여기선 controller만 써서 가능
public class HelloControllerTest {
    @Autowired //스프링이 관리하는 빈 주입받음
    private MockMvc mvc;//웹 api테스트시 사용. 스프링 mvc테스트의 시작점
    //이클래스로 http get,post에 대한 api 테스트 가능

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";
        mvc.perform(get("/hello"))//mockmvc를 통해 /hello 주소로 HTTP GET 요청
                .andExpect(status().isOk())//perform결과 검증
                .andExpect(content().string(hello));//hello리턴하나 검증
    }
    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "Hello";
        int amount = 1000;
        mvc.perform(get("/hello/dto")
                .param("name",name).param("amount",String.valueOf(amount)))
                //API 테스트할 때 사용될 요청 파라미터를 설정. 값은 string만 가능.
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                //json응답값을 필드별로 검증할 수 있는 메소드. $을 기준으로 필드명 명시
                .andExpect(jsonPath("$.amount",is(amount)));
    }

}
