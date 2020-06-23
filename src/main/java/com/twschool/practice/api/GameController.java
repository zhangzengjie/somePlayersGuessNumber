package com.twschool.practice.api;


import com.twschool.practice.domain.GameStatus;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.repository.GameRepository;
import com.twschool.practice.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2020/6/22 15:41
 * @Version 1.0
 */
@RestController
public class GameController {
    @Autowired
    private GameService gameService;

    @Autowired
    private GameRepository gameRepository;
    private int countResult =0;
    //list中用来存放连胜次数，当连胜中断时，list清空
    //map中用来存放玩家和其中key表示玩家ID，value是list表示连胜次数连胜次数
    private Map<String,List<Integer>> mapUserContuineWin;
    @PostMapping("/games/guess-numbers")
    public Map<String,String> guess(@RequestBody Map<String,String> requestBody) throws Exception {
        List<Integer> listContuineWin = null;
        mapUserContuineWin = new HashMap<>();
        //玩的次数
        int sumIndex = 0;
        String number = requestBody.get("number");
        //当多人玩家时
        String userNumber = requestBody.get("userId");
        String result = gameService.guess(number);
        List userGuessList = null;
        if (result.equals("Success")){
//            sumIndex=sumIndex++;
            if (sumIndex == 0) {
                listContuineWin.add(1);
                mapUserContuineWin.put(userNumber, listContuineWin);
            } else if (sumIndex !=0) {
                userGuessList = mapUserContuineWin.get(number);
            }
            countResult = countResult+3;
            if (userGuessList.size()%3 == 0){
                countResult = countResult+2;
            } else if (userGuessList.size()%5 == 0) {
                countResult = countResult+3;
            }
            Map<String,String> responseBody = new HashMap<>();
            responseBody.put("result",result);
            responseBody.put("当前得分:",countResult+"");
        } else if (result.equals("Fail")) {
            //当失败一次，连胜的list清空,并将map中的对应的map清空
            mapUserContuineWin.remove(userNumber);
            countResult = countResult-3;
            Map<String,String> responseBody = new HashMap<>();
            responseBody.put("result",result);
            responseBody.put("当前得分:",countResult+"");
        }
        return requestBody;
    }
    @GetMapping("/games/start-game")
    public List<String> start(){
        gameService.start();
        List responseBody = new ArrayList();
        responseBody.add("新的比赛开始");
        return responseBody;
    }



}
