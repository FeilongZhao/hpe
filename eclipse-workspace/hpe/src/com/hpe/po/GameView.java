package com.hpe.po;

import java.util.Date;

/*
 * 游戏试图展示实体类：
    主要用于展示游戏排行信息，主要定义用户姓名、积分、时间（直接从游戏实体数据表中读取）、同时包括构造方法、get/set方法、tostring方法；

 */
public class GameView {
    
    private String userName;
    private int integral;
    private Date time;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
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
        return "GameView [userName=" + userName + ", integral=" + integral + ", time=" + time + "]";
    }
    
    

}
