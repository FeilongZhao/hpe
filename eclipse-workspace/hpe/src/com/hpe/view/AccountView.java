package com.hpe.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.hpe.po.Users;

/*
 * 账户登录，注册，维护，修改密码
 */
public class AccountView {
    
    private Scanner scanner = null;

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

    public int loginInSuccessView(String time) {

        System.out.println("------个人生活助手平台------" + "\n");
        System.out.println("********【欢迎您，用户" + "上次登录时间：" + time +"】" + "********" + "\n");
        System.out.println("1.信息维护    2.修改密码    3.个人钱包    4.备忘录    5.娱乐天地    0.返回登录主菜单");
        
        return new Scanner(System.in).nextInt();

    }

    public Users registerView() {
        
        scanner = new Scanner(System.in);
        Users users = new Users();
        System.out.println("------个人生活助手平台------" + "\n");
        System.out.println("********" + "用户注册" + "********" + "\n");
        System.out.println("请输入用户名：");
        users.setUserName(scanner.nextLine());
        System.out.println("请输入密码：");
        users.setUserPassword(scanner.nextLine());
        System.out.println("请输入真实姓名：");
        users.setRealName(scanner.nextLine());
        System.out.println("请输入电话号码：");
        users.setTel(scanner.nextLine());
        System.out.println("请输入联系地址：");
        users.setAddress(scanner.nextLine());
        
        return users;
    }
    
    public Users maintenanceView() {
        
        scanner = new Scanner(System.in);
        Users users = new Users();
        
        System.out.println("------个人生活助手平台------" + "\n");
        System.out.println("********" + "信息维护"  + "********" + "\n");
        System.out.println("请输入用户名：");
        users.setUserName(scanner.nextLine());
        System.out.println("请输入真实姓名：");
        users.setRealName(scanner.nextLine());
        System.out.println("请输入电话号码：");
        users.setTel(scanner.nextLine());
        System.out.println("请输入联系地址：");
        users.setAddress(scanner.nextLine());
        return users;
       
    }
    public Map updatePasswordView() {
        
        
        String onePassword = null;
        String twoPassword = null;
       Map<String, String> password = new HashMap<>();
       scanner = new Scanner(System.in);
        
        System.out.println("------个人生活助手平台------" + "\n");
        System.out.println("********" + "修改密码" + "********" + "\n");
        
        do {
            System.out.println("请输入原密码：");
            password.put("oldPassword", scanner.nextLine());
            System.out.println("请输入新密码：");
            onePassword = scanner.nextLine();
            password.put("newPassword",onePassword );
            System.out.println("再次输入新密码：");
            twoPassword = scanner.nextLine();
        } while (!onePassword.equals(twoPassword));
        
        return password;
    }

}
