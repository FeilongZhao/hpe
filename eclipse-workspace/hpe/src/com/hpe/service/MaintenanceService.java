package com.hpe.service;

import com.hpe.dao.UserDate;
import com.hpe.po.Users;

public class MaintenanceService {
    
    private UserDate userDate = null;
    public void main(Users users) {
        
        userDate = new UserDate();
        userDate.maintenanceUserDate(users);
        
    }

}
