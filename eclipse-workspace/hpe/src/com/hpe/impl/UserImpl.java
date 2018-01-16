package com.hpe.impl;

import com.hpe.po.Users;

public interface UserImpl {

    boolean userLogin(String userName,String password);// 用户登录

    boolean userRegister(Users user);// 用户注册

    boolean checkUser(String userName);// 验证用户

    Boolean maintenanceUserDate(Users user);// 维护用户数据

    boolean revisePassword(String newPassword, String oldPassword,int userId);// 修改密码
}
