package com.hpe.impl;

import java.math.BigDecimal;

import com.hpe.po.Account;

public interface AccountImpl {

    Account getAccountMoney(int userId); // 余额查询

    Boolean saveMoney(int userId,BigDecimal money); // 存钱

    Boolean ransferAccounts(int accountId,int myId,BigDecimal money); // 转账

    boolean checkAccount(int accountId); // 验证用户账户

    BigDecimal income(int myId); // 当月收入

    BigDecimal pay(int myId); // 当月支出

}
