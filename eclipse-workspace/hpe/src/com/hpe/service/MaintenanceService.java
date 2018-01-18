package com.hpe.service;

import java.util.Map;

import com.hpe.dao.UserDate;
import com.hpe.po.Users;
import com.hpe.view.MemorandumView;

public class MaintenanceService {
    
    private UserDate userDate = null;
    public void main(Users users) {
        
        userDate = new UserDate();
        userDate.maintenanceUserDate(users);
        
    }
}
