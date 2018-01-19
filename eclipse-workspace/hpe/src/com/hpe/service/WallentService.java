package com.hpe.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.hpe.dao.AccountDate;
import com.hpe.dao.UserDate;
import com.hpe.po.Account;

public class WallentService {
    
    private AccountDate accountDate = null;
    private Map<String, BigDecimal> money = null;
    public Account getAccountMoney() {
        
        accountDate = new AccountDate();
        
        
        return accountDate.getAccountMoney(UserDate.userId);
    }
    
    public void savaMoney(BigDecimal money) {
        
        accountDate = new AccountDate();
        
        accountDate.saveMoney(UserDate.userId, money);
      //  System.out.println(UserDate.userId);
    }
    public void  ransferMoney(Map  ransfer) {
        
       accountDate = new AccountDate();
       if (accountDate.checkAccount(Integer.parseInt(ransfer.get("帐号").toString()))) {
           
           accountDate.ransferAccounts(Integer.parseInt(ransfer.get("帐号").toString())
                   , UserDate.userId, new BigDecimal(ransfer.get("金额").toString()));
    }else {
        System.err.println("账户不存在");
    }
       
    }
    
    public Map count() {
        
        accountDate = new AccountDate();
       
        money = new HashMap<>();
        System.err.println(UserDate.userId);
        money.put("收入", accountDate.income(UserDate.userId));
        money.put("支出", accountDate.pay(UserDate.userId));
        return money;
    }
    

}
