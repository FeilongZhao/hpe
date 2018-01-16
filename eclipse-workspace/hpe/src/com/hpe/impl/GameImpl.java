package com.hpe.impl;

import java.util.List;

import com.hpe.po.Ranking;

public interface GameImpl {

    boolean addGameDate();

    List<Ranking> getGameRanking();

}
