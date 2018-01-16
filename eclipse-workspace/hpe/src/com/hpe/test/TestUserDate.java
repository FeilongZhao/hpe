package com.hpe.test;

import java.util.Date;

import org.junit.Test;

import com.hpe.dao.UserDate;
import com.hpe.po.Users;

public class TestUserDate {

    @Test
    public void testRegister() {
        UserDate userDate = new UserDate();
        //userDate.userRegister();
        Users users = new Users();
        users.setUserName("小兰");
        users.setUserPassword("123");
        users.setRealName("小兰");
        users.setTel("123456789");
        users.setAddress("china");
        users.setLogin_time(new Date());
        System.out.println(userDate.userRegister(users));
    }
    
    @Test
    public void testLogin() {
        UserDate userDate = new UserDate();
        
        System.out.println(userDate.userLogin("小红","123"));
    }
    @Test
    public void testCheck() {
        UserDate userDate = new UserDate();
        System.out.println(userDate.checkUser("小明"));
    }
    @Test
    public void testMaintenanceUserDate() {
        UserDate userDate = new UserDate();
        Users users = new Users();
        users.setUserId(3);
        users.setUserName("小花");
        users.setRealName("小花");
        users.setTel("123456");
        users.setAddress("上海");
        
        System.out.println(userDate.maintenanceUserDate(users));
    }
    @Test
    public void testRevisePassword() {
        UserDate userDate = new UserDate();
        System.out.println(userDate.revisePassword("456","123",3));
    }
    
    @Test
    public void testSaveLoginTime() {
        UserDate userDate = new UserDate();
       // System.out.println(userDate.saveLoginTime("小明"));
    }
    
}
