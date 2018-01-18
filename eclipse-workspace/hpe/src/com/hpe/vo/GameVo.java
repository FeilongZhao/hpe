package com.hpe.vo;

import java.util.Date;
import java.util.List;

import com.hpe.dao.UserDate;
import com.hpe.po.Game;
import com.hpe.po.Ranking;
import com.hpe.service.GameService;
import com.hpe.service.LoginInService;
import com.hpe.view.AccountView;
import com.hpe.view.GameShowView;

public class GameVo {

    private GameShowView gameShowView = null;
    private int index = 0;
    private GameService gameService = null;
    private Game game = null;
    private List<Ranking> list = null;
    private LoginInVo loginInVo = null;
    private LoginInService loginInService = null;
    private PersonalVo personalVo = null;
    private AccountView accountView = null;

    public void main() {

        gameShowView = new GameShowView();
        index = gameShowView.mainView();

        switch (index) {
        case 1:

            game();
            main();

            break;
        case 2:
            ranking();
            main();
            break;
        case 3:
            loginInVo = new LoginInVo();
            loginInService = new LoginInService();
            personalVo = new PersonalVo();
            accountView = new AccountView();
            loginInVo.personalMain(loginInService, personalVo, UserDate.USERNAME, accountView);

            break;

        default:
            System.out.println("输入错误，请重新输入！");
            main();
            break;
        }

    }

    private void game() {
        gameService = new GameService();
        gameShowView = new GameShowView();
        int i = 0;
        int score = 0;
        i = gameShowView.gameView();
        if (i > 3) {
            System.out.println("输入错误，重新输入！！！");
            i = gameShowView.gameView();
        }
        int k = 0;
        k = gameService.playGame(i);
        // computerRe(k);
        showRe(k);

        while (k != -1) {

            score += k;
            i = gameShowView.gameView();
            if (i > 3) {
                System.out.println("输入错误，重新输入！！！");
                i = gameShowView.gameView();
            }
            k = gameService.playGame(i);
            // computerRe(k);
            showRe(k);
        }

        game = new Game();
        game.setIntegral(score);
        game.setUserId(UserDate.userId);
        game.setTime(new Date());
        gameService.addGameDate(game);

        System.out.println("游戏结束！！！");

    }

    private void ranking() {
        
        gameService = new GameService();
        gameShowView = new GameShowView();
        list = gameService.getGameRanking();
        gameShowView.rankingView();
        int i = 1;
        for (Ranking ranking : list) {
            System.out.println(i + "         " + ranking.getUserName() + "       " + ranking.getIntegral() + "      " + ranking.getTime());
            i++;
        }
        
        

    }

    private void showRe(int k) {

        switch (k) {
        case 1:
            System.out.println("电脑输了，你赢了！");

            break;

        case 0:
            System.out.println("和局");
            break;
        case -1:
            System.out.println("你输了，电脑赢了！");
            break;
        }
    }

}
