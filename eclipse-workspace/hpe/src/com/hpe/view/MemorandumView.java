package com.hpe.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MemorandumView {
    
    private Scanner scanner = null;
    private Map<String, String> content = null;
    
    public int mainView() {
        
        scanner = new Scanner(System.in);
        System.out.println("------我的备忘录------" + "\n");
        System.out.println("********【欢迎您用户：" + " " + "上次登陆时间：" + " " + "】********");
        System.out.println("1.查看备忘录    2.添加备忘录    3.修改备忘录    4.删除备忘录    0.返回主菜单");
        System.out.println("********" + "个人备忘录" + "********");
        
        return scanner.nextInt();
        
    }
    
    public void myMemorandumView() {
        
        System.out.println("------我的备忘录------" + "\n");
        System.out.println("********" + "查看备忘录" + "********");
        System.out.println("编号" + "    " + "标题" + "     " + "时间" + "              " + "内容" + "    " );
           
    }
    
    public Map<String, String> addMemorandumView() {
        
        content = new HashMap<>();
        scanner = new Scanner(System.in);
        System.out.println("------我的备忘录------" + "\n");
        System.out.println("********" + "添加备忘录" + "********");
        System.out.println("请输入标题：");
        content.put("标题", scanner.nextLine());
        System.out.println("请输入内容：");
        content.put("内容", scanner.nextLine());
        
        return content;
    }
    
    public Map updateMemorandumView() {
        
        scanner = new Scanner(System.in);
        content = new HashMap<>();
        System.out.println("------我的备忘录------" + "\n");
        System.out.println("********" + "修改备忘录" + "********");
        System.out.println("编号" + " " + "标题" + " " + "时间" + " " + "内容" + " " );
        System.out.println("请输入要修改的备忘录编号：");
        content.put("i", scanner.nextLine());
        System.out.println("请输入标题：");
        content.put("标题", scanner.nextLine());
        System.out.println("请输入内容：");
        content.put("内容", scanner.nextLine());
        return content;
    }
    
    public int deleteMemorandumView() {
        
        scanner = new Scanner(System.in);
        System.out.println("------我的备忘录------" + "\n");
        System.out.println("********" + "删除备忘录" + "********");
       // System.out.println("编号" + " " + "标题" + " " + "时间" + " " + "内容" + " " );
        System.out.println("请输入要删除的备忘录编号：");
        
        return scanner.nextInt();
    }

}
