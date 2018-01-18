package com.hpe.vo;

import java.util.Scanner;

import com.hpe.po.LoginUser;
import com.hpe.service.LoginInService;
import com.hpe.view.AccountView;

public class LoginInVo {
    
    public void main() {
        
        int i = 0;
        
        LoginInService loginInService = new LoginInService();
        PersonalVo personalVo = new PersonalVo();
        
        Scanner scanner = new Scanner(System.in);
        LoginUser user = new LoginUser();
        AccountView accountView = new AccountView();
        accountView.signUserNameView();
        user.setUserName(scanner.nextLine()); 
        accountView.signPassword();
        user.setPassword(scanner.nextLine());
        
        
        if (loginInService.login(user)) {
            personalMain(loginInService, personalVo, user.getUserName(), accountView);
            
        }else {
            System.err.println(user.getUserName());
            System.err.println("cuowu");
        }
        scanner.close();
    }

    public void personalMain(LoginInService loginInService, PersonalVo personalVo, String userName,
            AccountView accountView) {
        int i;
        i = accountView.loginInSuccessView(loginInService.time(userName));
        personalVo.main(i);
    }
    
}
