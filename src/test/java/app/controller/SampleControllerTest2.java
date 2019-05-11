package app.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class) // controller 하나만 테스트(웹 관련된것들은 빈으로 등록 되지만, 서비스,리파지터리 는 등록이 안됨), 웹 계층 밑에 애들은 다 의존성이 끊길것이다.
public class SampleControllerTest2 {
    @MockBean // 웹 이외의 항목에 대해 별도로 빈으로 등록
    SampleService sampleService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {

        when(sampleService.getName()).thenReturn("service-get-name");

        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("helloservice-get-name"))
                .andDo(print());
    }
}