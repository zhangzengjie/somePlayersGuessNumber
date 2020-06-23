package com.twschool.practice.domain.service;

import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.service.GameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2020/6/22 16:56
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class GameServiceTest {
    @Test
    public void should_return_result_when_guess_number(){
        //GuessNumberGame guessNumberGame = Mockito.mock(GuessNumberGame.class);
        //GameService gameService = new GameService(guessNumberGame);

        //gameService.guess("1 2 3 4");

        //Mockito.verify(guessNumberGame,Mockito.times(1)).guess(Mockito.eq("1 2 3 4"));
    }

}
