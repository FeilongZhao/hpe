package com.hpe.po;

import java.util.Date;

/*
 * 主要用于定义游戏ID、用户ID、用户积分、时间（玩游戏的时间），同时包括构造方法、get/set方法、tostring方法；
 */
public class Game {

    private int gameId;
    private int userId;
    private int integral;
    private Date time;
    public int getGameId() {
        return gameId;
    }
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getIntegral() {
        return integral;
    }
    public void setIntegral(int integral) {
        this.integral = integral;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
    @Override
    public String toString() {
        return "Game [gameId=" + gameId + ", userId=" + userId + ", integral=" + integral + ", time=" + time + "]";
    }
    
    
}
