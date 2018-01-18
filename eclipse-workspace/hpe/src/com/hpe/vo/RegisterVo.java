package com.hpe.vo;

import java.util.Scanner;

import com.hpe.dao.UserDate;
import com.hpe.po.Users;
import com.hpe.service.RegisterService;
import com.hpe.view.AccountView;

public class RegisterVo {

    private Users users = null;
    private Scanner scanner = null;
    private RegisterService registerService = null;
    public void main() {
        

        AccountView accountView = new AccountView();
        registerService = new RegisterService();
        users = accountView.registerView();
        registerService.main(users);
        
    }
}
