package com.twschool.practice.repository;

import com.twschool.practice.domain.AnswerGenerator;
import com.twschool.practice.domain.GuessNumberGame;
import org.springframework.stereotype.Repository;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2020/6/22 17:49
 * @Version 1.0
 */
@Repository
public class GameRepository {
    private GuessNumberGame guessNumberGame;

    public GuessNumberGame create(){
        guessNumberGame = new GuessNumberGame(new AnswerGenerator());
        return guessNumberGame;
    }

    public GuessNumberGame find(){
        return guessNumberGame;
    }

}
