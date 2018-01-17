package com.hpe.vo;

import java.util.Scanner;

import com.hpe.view.AccountView;

public class MainVo {

    private AccountView accountView = new AccountView();
    private LoginInVo loginInVo = new LoginInVo();
    private Scanner scanner = new Scanner(System.in);

    // 主菜单
    public void main() {
        int num;
        accountView.mainView();
        System.out.println("请选择：");
        num = scanner.nextInt();
        while (num < 0 || num > 3) {
            System.err.println("输入错误!请重新输入");
            num = scanner.nextInt();
        }
        switch (num) {
        case 1:
            loginInVo.main();
            break;

        case 2:

            break;
        case 3:

            break;
        default:

        }
    }
}
