package com.hpe.test;

import org.junit.Test;

import com.hpe.view.WalletView;
import com.hpe.vo.WallentVo;

public class TestCheeck {

    @Test
    public void testheck() {

        WalletView walletView = new WalletView();
       // walletView.check("123.3");
        System.out.println(walletView.check("1234.3"));
        System.out.println(walletView.check("aaa.213"));
        System.out.println(walletView.check("123.a"));
        System.out.println(walletView.check("asdad.asd"));
        System.out.println(walletView.check("12121231"));

    }
}
