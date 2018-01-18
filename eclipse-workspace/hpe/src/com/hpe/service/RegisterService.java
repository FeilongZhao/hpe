package com.hpe.service;

import java.util.Date;

import com.hpe.dao.UserDate;
import com.hpe.po.Users;

public class RegisterService {
    
  private UserDate userDate = null;
  
  
  public void main(Users users) {
      
      userDate = new UserDate();
      Date date = new Date();
      users.setLogin_time(date);
      userDate.userRegister(users);
  }
    
    

}
