package com.hpe.po;

import java.util.Date;

/*
 * 主要用于定义游戏ID、用户ID、用户积分、时间（玩游戏的时间），
 * 同时包括构造方法、get/set方法、tostring方法；
 */
public class Ranking {
    
    private int rankingId;
    private int userId;
    private String userName;
    private int integral;
    private Date time;
    public int getRankingId() {
        return rankingId;
    }
    public void setRankingId(int rankingId) {
        this.rankingId = rankingId;
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
    
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public String toString() {
        return "Ranking [rankingId=" + rankingId + ", userId=" + userId + ", userName=" + userName + ", integral="
                + integral + ", time=" + time + "]";
    }
  
    
}
