package com.hpe.po;

import java.math.BigDecimal;
import java.util.Date;

/*
 * 主要用于记录本系统的操作日志信息，主要定义日志ID、账户ID、余额、余额转入账户ID、余额转入转出类型、
 * 时间（余额转动操作时间、游戏开始时间、游戏结束时间、登录系统时间、退出系统时间）等；
 */
public class Account_log {

    
    private int log_id;
    private int accountId;
    private int transfer_account;
    private String type;
    private Date log_time;
    private BigDecimal money;//余额
    public int getLog_id() {
        return log_id;
    }
    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public int getTransfer_account() {
        return transfer_account;
    }
    public void setTransfer_account(int transfer_account) {
        this.transfer_account = transfer_account;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Date getLog_time() {
        return log_time;
    }
    public void setLog_time(Date log_time) {
        this.log_time = log_time;
    }
    public BigDecimal getMoney() {
        return money;
    }
    public void setMoney(BigDecimal money) {
        this.money = money;
    }
    @Override
    public String toString() {
        return "Account_log [log_id=" + log_id + ", accountId=" + accountId + ", transfer_account=" + transfer_account
                + ", type=" + type + ", log_time=" + log_time + ", money=" + money + "]";
    }
    
    
}
