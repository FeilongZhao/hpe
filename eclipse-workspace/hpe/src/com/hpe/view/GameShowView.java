package com.hpe.view;

public class GameShowView {

    public void mainView() {

        System.out.println("--------娱乐天地--------");
        System.out.println("********【欢迎您，用户：" + "】********");
        System.out.println("1.猜拳游戏    2.游戏排行榜    3.返回主菜单");
        System.out.println("********娱乐天地********");
    }
    
    public void gameView() {
        
        System.out.println("请出拳：1。剪刀    2.石头    3.布");
        System.out.println("玩家出：" + "");
        System.out.println("电脑出：" + "");
        System.out.println("和局");
        System.out.println("你输了，电脑赢了！");
        System.out.println("电脑输了，你赢了！");
    }
    
    public void rankingView() {
        
        System.out.println("--------娱乐天地--------");
        System.out.println("********游戏排行榜********");
        System.out.println("排名         姓名         积分      时间");
        
    }

}
