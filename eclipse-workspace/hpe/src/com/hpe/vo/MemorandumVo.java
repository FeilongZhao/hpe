package com.hpe.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hpe.dao.UserDate;
import com.hpe.po.Memorandum;
import com.hpe.service.LoginInService;
import com.hpe.service.MemorandumViewService;
import com.hpe.view.AccountView;
import com.hpe.view.MemorandumView;

public class MemorandumVo {

    private MemorandumView memorandumView = null;
    private int i = 0;
    private Map<String, String> content = null;
    private MemorandumViewService memorandumViewService = null;
    private List<Memorandum> list = null;
    private LoginInVo loginInVo = null;

    public void main() {

        memorandumView = new MemorandumView();
        i = memorandumView.mainView();

        switch (i) {
        case 1:
            
            getMemorandum();
            break;
        case 2:
            
            addMemorandumView(memorandumView);
            break;
        case 3:
            
            updateMemorandum();
            break;
        case 4:   
            
            deleteMemorandum();
            break;
        case 0:
            loginInVo = new LoginInVo();
            loginInVo.personalMain(new LoginInService(), new PersonalVo(), UserDate.USERNAME, new AccountView());
            break;

        default:
            System.out.println("输入错误，请重新输入");
            main();
            break;
        }
    }

    private void addMemorandumView(MemorandumView memorandumView) {

        content = memorandumView.addMemorandumView();
        memorandumViewService = new MemorandumViewService();
        if (memorandumViewService.main(content)) {
            System.out.println("添加成功!");
        }
        main();

    }

    private void getMemorandum() {
        int i = 1;
        memorandumViewService = new MemorandumViewService();
        memorandumView = new MemorandumView();
        memorandumView.myMemorandumView();
        list = memorandumViewService.getMemorandum();
        for (Memorandum memorandum : list) {
            System.out.println(i + "      " + memorandum.getMemorandum_title() + "    " + memorandum.getTime() + "    "
                    + memorandum.getContent());
            i++;
        }

        main();
    }

    private void updateMemorandum() {

        content = new HashMap<>();
        memorandumViewService = new MemorandumViewService();
        int i = 1;
        memorandumViewService = new MemorandumViewService();
        memorandumView = new MemorandumView();
        memorandumView.myMemorandumView();
        
        list = memorandumViewService.getMemorandum();
        for (Memorandum memorandum : list) {
            System.out.println(i + "      " + memorandum.getMemorandum_title() + "    " + memorandum.getTime() + "    "
                    + memorandum.getContent());
            i++;
        }
        memorandumView = new MemorandumView();
        content = memorandumView.updateMemorandumView();
        if (memorandumViewService.updateMemorandum(content)) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
        main();
    }

    private void deleteMemorandum() {
        
        memorandumViewService = new MemorandumViewService();
        memorandumView = new MemorandumView();
        memorandumView.myMemorandumView();
        int i = 1;
       
        list = memorandumViewService.getMemorandum();
        for (Memorandum memorandum : list) {
            System.out.println(i + "      " + memorandum.getMemorandum_title() + "    " + memorandum.getTime() + "    "
                    + memorandum.getContent());
            i++;
        }
        i = memorandumView.deleteMemorandumView();
        if (i <= list.size() && i > 0) {
              memorandumViewService.deleteMemorandum(i);
              main();
        }else {
            System.out.println("备忘录不存在！！");
            main();
        }
    }

}
