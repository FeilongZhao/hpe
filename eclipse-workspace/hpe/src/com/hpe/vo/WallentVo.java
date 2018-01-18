package com.hpe.vo;

import java.math.BigDecimal;
import java.util.Map;

import com.hpe.dao.UserDate;
import com.hpe.po.Account;
import com.hpe.service.LoginInService;
import com.hpe.service.WallentService;
import com.hpe.view.AccountView;
import com.hpe.view.WalletView;

public class WallentVo {

    private WalletView walletView = null;
    private WallentService wallentService = null;
    private Account account = null;
    private Map ransferMoney = null;
    private Map countMoney = null;
    private LoginInVo loginInVo = null;
    private LoginInService loginInService = null;
    private PersonalVo personalVo = null;
    private AccountView accountView = null;
   

    private int i = 0;

    public void main() {
        walletView = new WalletView();
        i = walletView.mainView();

        switch (i) {
        case 1:
            personWalletView();
            break;

        case 2:
            savaMoneyView();
            break;
        case 3:
            ransferAccountsView();
            break;
        case 4:
            countView();
            break;

        case 0:
            loginInVo = new LoginInVo();
            loginInService = new LoginInService();
            personalVo = new PersonalVo();
            accountView = new AccountView();
            loginInVo.personalMain(loginInService, personalVo, UserDate.USERNAME, accountView);
            break;
        default:
            System.err.println("输入不合法！");
            break;
        }

    }

    private void personWalletView() {

        wallentService = new WallentService();
        account = new Account();
        account = wallentService.getAccountMoney();
        walletView.personWalletView(account);

    }

    private void savaMoneyView() {
        String money = null;
        wallentService = new WallentService();
        money = walletView.savaMoneyView();
        wallentService.savaMoney(new BigDecimal(money));
        walletView.view();

    }

    private void ransferAccountsView() {

        ransferMoney = walletView.ransferAccountsView();
        wallentService = new WallentService();
        wallentService.ransferMoney(ransferMoney);
        walletView.view();
    }

    private void countView() {

        wallentService = new WallentService();
        countMoney = wallentService.count();
        walletView.countView(countMoney);
        walletView.view();
    }

}
