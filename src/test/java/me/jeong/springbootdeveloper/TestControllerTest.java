package me.jeong.springbootdeveloper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc

class TestControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    public void mockMvcSetup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @AfterEach
    public void cleanUp() {
        memberRepository.deleteAll();
    }

    @DisplayName("getAllMembers : 아티클 조회에 성공한다")
    @Test
    public void getAllMembers() throws Exception {
        final String url = "/test";
        Member savedMember = memberRepository.save(new Member(1L, "홍길동"));

        final ResultActions result = mockMvc.perform(get(url)).accept(MediaType.APPLICATION_JSON);

        result
                .andExcept(status().isOk())
                .andExcept(jsonPath("$[0].id").value(savedMember.getId()))
                .andExcept(jsonPath("$[0].name").value(savedMember.getName()));
    }


}