package com.hpe.vo;

import java.util.Scanner;

import com.hpe.po.LoginUser;
import com.hpe.service.LoginInService;
import com.hpe.view.AccountView;

public class LoginInVo {

    private PersonalVo personalVo = null;
    private LoginInService loginInService = null;
    private Scanner scanner = null;
    private LoginUser user = null;
    private AccountView accountView = null;
    private MainVo mainVo = null;

    public void main() {

        int i = 2;

        loginInService = new LoginInService();
        personalVo = new PersonalVo();
        scanner = new Scanner(System.in);
        user = new LoginUser();
        accountView = new AccountView();
        
        
        
        accountView.signUserNameView();
        user.setUserName(scanner.nextLine());
        accountView.signPassword();
        user.setPassword(scanner.nextLine());

        while (!loginInService.login(user) && i > 0) {
            
           // System.err.println("密码或用户名输入错误！请重新输入！！！" + "还有" + i + "机会");  
            System.out.println("密码或用户名输入错误！请重新输入！！！" + "还有" + i + "机会");
            accountView.signUserNameView();
            user.setUserName(scanner.nextLine());
            accountView.signPassword();
            user.setPassword(scanner.nextLine());
            i--;

        }
        if (i == 0) {
            mainVo = new MainVo();
            System.out.println("连续输入错误三次" + "\n");
            System.out.println("请确认后再输入" + "\n");
            mainVo.main();
        }

        if (loginInService.login(user)) {
            personalMain(loginInService, personalVo, user.getUserName(), accountView);

        } else {
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
