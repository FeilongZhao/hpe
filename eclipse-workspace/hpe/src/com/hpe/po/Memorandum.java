package com.hpe.po;

import java.util.Date;

/*
 * 主要定义备忘录的备忘录ID、标题、时间、内容、对应的用户ID，同时包括构造方法、get/set方法、tostring方法
 */
public class Memorandum {
    
    private int memorandum_id;
    private String memorandum_title;
    private Date time;
    private String content;
    private int userId;
    public int getMemorandum_id() {
        return memorandum_id;
    }
    public void setMemorandum_id(int memorandum_id) {
        this.memorandum_id = memorandum_id;
    }
    public String getMemorandum_title() {
        return memorandum_title;
    }
    public void setMemorandum_title(String memorandum_title) {
        this.memorandum_title = memorandum_title;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
   
}
