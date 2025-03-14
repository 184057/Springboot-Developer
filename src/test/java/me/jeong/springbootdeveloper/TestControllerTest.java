package me.jeong.springbootdeveloper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

class TestControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;


    @BeforeEach
    public void mockMvcSetup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    @AfterEach
    public void cleanUp() {
        memberRepository.deleteAll();
    }

    @DisplayName("getAllMembers : 아티클 조회에 성공한다")
    @Test
    public void getAllMembers() throws Exception {
        //given : 멤버를 저장한다
        final String url = "/test";
        Member savedMember = memberRepository.save(new Member(1L, "홍길동"));

        //when : 멤버 리스트를 조회하는 API를 호출
        final ResultActions result = mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON));
        //perform() 메서드는 요청을 전송하는 역할을 하는 메서드, 결과로 ResultAction 객체를 받으며 ResultAction 객체는 반환값을 검증하고 확인하는 andExcept() 메서드를 제공
        //accept() 메서드는 요청을 보낼 때 무슨 타입으로 응답을 받을지 결정하는 메서드, JSON, XML 등 다양한 타입이 있음. 여기서는 JSON 사용

        //then : 응답 코드가 200 OK이고, 반환받은 값 중에 0번째 요소의 id와 name이 저장된 값과 같은지 확인함
        result
                .andExpect(status().isOk())
                //andExcept() 메서드는 응답을 검증하며, TestController에서 만든 API는 응답으로 OK(200)을 반환하므로 이에 해당하는 메서드인 isOk를 사용해 응답코드가 OK(200)인지 확인함
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
                //jsonPath("$[0].${필드명}")은 JSON 응답값을 가져오는 역할을 하는 메서드이며 여기서는 0번째 배열에 들어있는 객체의 id, name값을 가져오고, 저장된 값과 같은지 확인한다.
    }


}