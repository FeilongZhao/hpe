package com.hpe.po;

import java.math.BigDecimal;

/*
 * 主要用于定义账户ID、账户余额、对应的用户ID；同时包括构造方法、get/set方法、tostring方法；
 */
public class Account {
    
    private int accountId;
    private BigDecimal accountMoney;
    private String userid;
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public BigDecimal getAccountMoney() {
        return accountMoney;
    }
    public void setAccountMoney(BigDecimal accountMoney) {
        this.accountMoney = accountMoney;
    }
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    @Override
    public String toString() {
        return "Account [accountId=" + accountId + ", accountMoney=" + accountMoney + ", userid=" + userid + "]";
    }
    
    

}
