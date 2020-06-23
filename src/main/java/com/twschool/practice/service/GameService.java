package com.twschool.practice.service;

import com.twschool.practice.domain.GameStatus;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2020/6/22 16:57
 * @Version 1.0
 */
@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public String guess(String userAnswerString){
        GuessNumberGame guessNumberGame = gameRepository.find();
        GameStatus gameStatus = guessNumberGame.getStatus();
        if (gameStatus==GameStatus.SUCCEED){
            return "Success";
        }else if (gameStatus==GameStatus.FAILED){
            return "Fail";
        } else {
            return guessNumberGame.guess(userAnswerString);
        }
    }

    public void start(){
        gameRepository.create();
    }



}
