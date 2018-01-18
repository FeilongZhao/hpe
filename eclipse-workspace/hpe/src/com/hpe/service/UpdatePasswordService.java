package com.hpe.service;

import com.hpe.dao.UserDate;

public class UpdatePasswordService {
    
    private UserDate userDate = null;
    public void main(String newPassword, String oldPassword) {
        
        userDate = new UserDate();
        userDate.revisePassword(newPassword, oldPassword);
    }

}
