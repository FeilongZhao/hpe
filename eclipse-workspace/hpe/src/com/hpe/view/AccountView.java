package com.hpe.view;

/*
 * 账户登录，注册，维护，修改密码
 */
public class AccountView {

    public void mainView() {

        System.out.println("------个人生活助手平台------" + "\n");
        System.out.println("*****1.登录*****" + "\n");
        System.out.println("*****2.注册*****" + "\n");
        System.out.println("*****0.退出*****" + "\n");
    }

    public void signUserNameView() {

        System.out.println("------个人生活助手平台------" + "\n");
        System.out.println("请输入用户名：");
        
    }

    public void signPassword() {
        System.out.println("请输入密码：");
    }

    public void loginInSuccessView() {

        System.out.println("------个人生活助手平台------" + "\n");
        System.out.println("********【欢迎您，用户" + "上次登录时间：" + "】" + "********" + "\n");
        System.out.println("1.信息维护    2.修改密码    3.个人钱包    4.备忘录    5.娱乐天地    0.返回登录主菜单");

    }

    public void registerView() {

        System.out.println("------个人生活助手平台------" + "\n");
        System.out.println("********" + "用户注册" + "********" + "\n");
        System.out.println("请输入用户名：");
        System.out.println("请输入密码：");
        System.out.println("请输入真实姓名：");
        System.out.println("请输入电话号码：");
        System.out.println("请输入联系地址：");
    }
    
    public void maintenanceView() {
        
        System.out.println("------个人生活助手平台------" + "\n");
        System.out.println("********【欢迎您，用户" + "上次登录时间：" + "】" + "********" + "\n");
        System.out.println("请输入用户名：");
        System.out.println("请输入真实姓名：");
        System.out.println("请输入电话号码：");
        System.out.println("请输入联系地址：");
       
    }
    public void updatePasswordView() {
        
        System.out.println("------个人生活助手平台------" + "\n");
        System.out.println("********" + "修改密码" + "********" + "\n");
        System.out.println("请输入原密码：");
        System.out.println("请输入新密码：");
        System.out.println("再次输入新密码：");
    }

}
