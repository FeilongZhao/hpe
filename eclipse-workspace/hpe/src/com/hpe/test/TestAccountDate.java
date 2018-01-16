package com.hpe.test;

import java.math.BigDecimal;

import org.junit.Test;

import com.hpe.dao.AccountDate;

public class TestAccountDate {
    
    @Test
    public void testGetAccountMoney() {
        AccountDate accountDate = new AccountDate();
        System.out.println(accountDate.getAccountMoney(1).toString());
        
    }
    @Test
    public void testSaveMoney() {
        AccountDate accountDate = new AccountDate();
       System.out.println(accountDate.saveMoney(1,new BigDecimal("20")));
    }
    @Test
    public void testRansferAccounts() {
        AccountDate accountDate = new AccountDate();
        System.out.println(accountDate.ransferAccounts(1, 2, new BigDecimal("20")));
    }
    @Test
    public void testCheckAccount() {
        AccountDate accountDate = new AccountDate();
        System.out.println(accountDate.checkAccount(1));
    }
    
    @Test
    public void testIncome() {
        AccountDate accountDate = new AccountDate();
        System.out.println(accountDate.income(1));
    }
    
    @Test
    public void testPay() {
        AccountDate accountDate = new AccountDate();
        System.out.println(accountDate.pay(1));
    }

}
