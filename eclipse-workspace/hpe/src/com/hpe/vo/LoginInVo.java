package com.hpe.vo;

import java.util.Scanner;

import com.hpe.po.LoginUser;
import com.hpe.view.AccountView;

public class LoginInVo {
    
    public void main() {
        Scanner scanner = new Scanner(System.in);
        LoginUser user = new LoginUser();
        AccountView accountView = new AccountView();
        accountView.signUserNameView();
        user.setUserName(scanner.nextLine()); 
        accountView.signPassword();
        user.setPassword(scanner.nextLine());
        scanner.close();
        
    }

}
