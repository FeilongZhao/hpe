package com.hpe.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.hpe.dao.GameDate;
import com.hpe.po.Game;
import com.hpe.po.Ranking;

public class TestGameDate {

    @Test
    public void testAdd() {
        
        GameDate gameDate = new GameDate();
        Game game = new Game();
        game.setUserId(1);
        game.setIntegral(50);
        game.setTime(new Date());
        gameDate.addGameDate(game);
    }
    
    @Test
    public void testRanking() {
        
        List<Ranking> list = null;
        GameDate gameDate = new GameDate();
        list = gameDate.getGameRanking(1);
        for (Ranking ranking : list) {
            System.out.println(ranking.getRankingId());
            System.out.println(ranking);
        }
        
    }
}
