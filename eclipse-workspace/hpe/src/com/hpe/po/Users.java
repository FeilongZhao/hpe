package com.hpe.po;

import java.util.Date;

/*
 * 主要用于定义用户ID、用户名、用户密码、地址、电话、真实姓名、上次登录时间等，
 * 同时包括构造方法、get/set方法、tostring方法；
 */
public class Users {
    
    private int userId;
    private String userName;
    private String userPassword;
    private String realName;
    private String tel;
    private String address;
    private Date login_time;
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getRealName() {
        return realName;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Date getLogin_time() {
        return login_time;
    }
    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }
    @Override
    public String toString() {
        return "Users [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", realName="
                + realName + ", tel=" + tel + ", address=" + address + ", login_time=" + login_time + "]";
    }
    
    

}
