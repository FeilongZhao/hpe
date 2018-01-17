package com.hpe.view;

public class WalletView {

    public void mainView() {

        System.out.println("------个人钱包------");
        System.out.println("1.查看余额    2.存钱    3.转账    4.统计查询    0.返回主菜单");
    }

    public void personWalletView() {
        
        System.out.println("您的账户：" + "您的余额是：");
    }
    
    public void savaMoneyView() {
        
        System.out.println("********存钱********");
        System.out.println("请输入存款金额：");
        System.out.println("您的账户成功存入：");
        
    }
    public void ransferAccountsView() {
        
        System.out.println("********存钱********");
        System.out.println("请输入对方账户：");
        System.out.println("请输入转账金额：");
        System.out.println("您的账户成功转出：" + "元");
    }
    
    public void countView() {
        
        System.out.println("当月收入统计：" + "元");
        System.out.println("当月支出统计：" + "元");
    }

}
