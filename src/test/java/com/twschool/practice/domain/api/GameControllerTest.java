package com.twschool.practice.domain.api;

import com.twschool.practice.service.GameService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2020/6/22 15:29
 * @Version 1.0
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class GameControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GameService gameService;

    @Before
    public void setUp(){
        //TODO
        Mockito.when(gameService.guess(Mockito.any())).thenReturn("4A0B");
    }

    @Test
    public void should_return_result_when_guess_number() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/games/guess-numbers")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"number\":\"1 2 3 4\"}"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.input").value("1 2 3 4"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("4A0B"));
    }

}
