package com.hpe.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.hpe.po.Account;
import com.hpe.vo.WallentVo;

public class WalletView {

    private Scanner scanner = null;
    private WallentVo wallentVo = null;
    private Map<String, String> ransfer = null;
    private String money = null;
    
    public int mainView() {

        scanner = new Scanner(System.in);
        System.out.println("------个人钱包------");
        System.out.println("1.查看余额    2.存钱    3.转账    4.统计查询    0.返回主菜单");
        
        return scanner.nextInt();
    }

    public void personWalletView(Account account) {
        
       System.out.println("您的账户是："+ account.getUserid() + "您的钱包账户：" + account.getAccountId()+ "   您的余额是：" + account.getAccountMoney());
       view();
       
    }
    
    public String savaMoneyView() {
        
        scanner = new Scanner(System.in);
        System.out.println("********存钱********");
        System.out.println("请输入存款金额：");
        money = scanner.nextBigDecimal().toString();
        System.out.println("您的账户成功存入：" + money);
       
        
        return money;
        
    }
    public Map ransferAccountsView() {
        
        scanner = new Scanner(System.in);
        ransfer = new HashMap<>();
      //  scanner.nextLine();
        System.out.println("********存钱********");
        System.out.println("请输入对方账户：");
        ransfer.put("帐号",scanner.nextLine() );
        System.out.println("请输入转账金额：");
        ransfer.put("金额", scanner.nextLine());
        System.out.println("您的账户成功转出：" +ransfer.get("金额") +"元");
        
        return ransfer;
    }
    
    public void countView(Map money) {
        
        System.out.println("当月收入统计：" + money.get("收入") + "元");
        System.out.println("当月支出统计："+ money.get("支出") + "元");
        
    }
    
    public void view() {
        wallentVo = new WallentVo();
        wallentVo.main();
        //mainView();
    }

}
