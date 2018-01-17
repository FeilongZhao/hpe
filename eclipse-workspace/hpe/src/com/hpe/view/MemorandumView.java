package com.hpe.view;

public class MemorandumView {
    
    
    public void mainView() {
        
        System.out.println("------我的备忘录------" + "\n");
        System.out.println("********【欢迎您用户：" + " " + "上次登陆时间：" + " " + "】********");
        System.out.println("1.查看备忘录    2.添加备忘录    3.修改备忘录    4.删除备忘录    0.返回主菜单");
        System.out.println("********" + "个人备忘录" + "********");
        
    }
    
    public void myMemorandumView() {
        
        System.out.println("------我的备忘录------" + "\n");
        System.out.println("********" + "查看备忘录" + "********");
        System.out.println("1.编号" + " " + "2.标题" + " " + "3.时间" + " " + "4.内容" + " " );
           
    }
    
    public void addMemorandumView() {
        
        System.out.println("------我的备忘录------" + "\n");
        System.out.println("********" + "添加备忘录" + "********");
        System.out.println("请输入标题：");
        System.out.println("请输入内容：");
    }
    
    public void updateMemorandumView() {
        
        System.out.println("------我的备忘录------" + "\n");
        System.out.println("********" + "修改备忘录" + "********");
        System.out.println("1.编号" + " " + "2.标题" + " " + "3.时间" + " " + "4.内容" + " " );
        System.out.println("请输入要修改的备忘录编号：");
        System.out.println("请输入标题：");
        System.out.println("请输入内容：");
    }
    
    public void deleteMemorandumView() {
        
        System.out.println("------我的备忘录------" + "\n");
        System.out.println("********" + "删除备忘录" + "********");
        System.out.println("1.编号" + " " + "2.标题" + " " + "3.时间" + " " + "4.内容" + " " );
        System.out.println("请输入要删除的备忘录编号：");
        
    }

}
