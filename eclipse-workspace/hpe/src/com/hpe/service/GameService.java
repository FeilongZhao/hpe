package com.hpe.service;

import java.util.List;
import java.util.Random;

import com.hpe.dao.GameDate;
import com.hpe.dao.UserDate;
import com.hpe.po.Game;
import com.hpe.po.Ranking;

public class GameService {

    // 1。剪刀 2.石头 3.布
    private Random random = null;
    private GameDate gameDate = null;
    private List<Ranking> list = null;

    public int playGame(int i) {

        random = new Random();
        int k = 0;
        k = random.nextInt(3) + 1;

        System.out.println("k===" + k);
        
        computerRe(k);                    
        switch (k) {
        case 1:           
            if (i == 2) {
                return 1;
            }else if (i == 1) {
                return 0;
            }else {
                return -1;
            }
        case 2:
            if (i == 1) {
                return -1;
            }else if (i == 2) {
                return 0;
            }else {
                return 1;
            }
        case 3:
            if (i == 1) {
                return 1;
            }else if (i == 2) {
             return -1;   
            }else {
                return 0;
            }
        }

        if (i > k) {
            return 1;
        } else if (i == k) {
            return 0;
        }
        return -1;
    }

    public void addGameDate(Game game) {

        gameDate = new GameDate();
        if (gameDate.addGameDate(game)) {

        } else {
            System.err.println("添加游戏数据失败!");
        }

    }
 
  private void computerRe(int k) {
        
        switch (k) {
        case 1:
            System.out.println("电脑出：剪刀");
            break;
        case 2:
            System.out.println("电脑出：石头");
            break;
        case 3:
            System.out.println("电脑出：布");
            break;       
        }
    }
  
  public List<Ranking> getGameRanking() {
    
      gameDate = new GameDate();
      list =gameDate.getGameRanking(UserDate.userId);
      return list;
}

}
