package com.hpe.service;

import com.hpe.dao.UserDate;
import com.hpe.po.LoginUser;

public class LoginInService {
    
    private UserDate userDate = null;
    
    
    public Boolean login(LoginUser user) {
        
        userDate = new UserDate();
        if (userDate.userLogin(user.getUserName(), user.getPassword())) {
            
            return true;
        }
        
        return false;
    }
    
    public String time(String userName) {
        
       userDate = new UserDate();
       
        
        return userDate.loginTime(userName);
        
    }

}
