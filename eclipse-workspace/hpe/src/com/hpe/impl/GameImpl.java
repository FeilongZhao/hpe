package com.hpe.impl;

import java.util.List;

import com.hpe.po.Game;
import com.hpe.po.Ranking;

public interface GameImpl {

    boolean addGameDate(Game game);

    List<Ranking> getGameRanking(int userId);

}
