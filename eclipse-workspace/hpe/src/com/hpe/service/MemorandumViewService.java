package com.hpe.service;

import java.awt.Menu;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.DoubleAdder;

import com.hpe.dao.MemorandumDate;
import com.hpe.dao.UserDate;
import com.hpe.po.Memorandum;

public class MemorandumViewService {

    private MemorandumDate memorandumDate = null;
    private Memorandum memorandum = null;
    private Date date = null;
    private List<Memorandum> list = null;

    public Boolean main(Map<String, String> content) {

        memorandumDate = new MemorandumDate();
        memorandum = new Memorandum();
        date = new Date();
        memorandum.setUserId(UserDate.userId);
        memorandum.setMemorandum_title(content.get("标题"));
        memorandum.setContent(content.get("内容"));
        memorandum.setTime(date);

        return memorandumDate.addMemorandum(memorandum);
    }

    public List<Memorandum> getMemorandum() {

        memorandumDate = new MemorandumDate();
        list = memorandumDate.getMemorandum(UserDate.userId);

        return list;
    }

    public Boolean updateMemorandum(Map content) {

        memorandumDate = new MemorandumDate();

        list = memorandumDate.getMemorandum(UserDate.userId);

        int k = 0;
        int index = 0;
        index = Integer.parseInt(content.get("i").toString());
        for (int i = 0; i < index - 1; i++) {
            k++;
        }

       // System.out.println("i=" + content.get("i").toString());
      //  System.out.println("k=" + k);
       // System.out.println("id=" + list.get(k).getMemorandum_id());
      //  System.out.println("content = " + list.get(k).getContent());
        memorandumDate.updateMemorandum(UserDate.userId, list.get(k).getMemorandum_id(), content);

        return true;

    }
    
    public Boolean deleteMemorandum(int i) {
        
        memorandumDate = new MemorandumDate();
        list = memorandumDate.getMemorandum(UserDate.userId);
        int k = 0;
        
        for (int j = 0; j < i - 1; j++) {
            k++;
        }
        
        memorandumDate.deleteMemorandum(UserDate.userId,list.get(k).getMemorandum_id());
        
        return true;
    }

}
