package com.hpe.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.hpe.dao.MemorandumDate;
import com.hpe.po.Memorandum;

public class TestMemorandumDate {
    
    @Test
    public void testAddMemorandum() {
        
        Memorandum memorandum = new Memorandum();
        MemorandumDate memorandumDate = new MemorandumDate();
        memorandum.setUserId(1);
        memorandum.setContent("aaaaaaaa");
        memorandum.setMemorandum_title("a");
        memorandum.setTime(new Date());
        memorandumDate.addMemorandum(memorandum);
    }
    
    @Test
    public void testDeleteMemorandum() {
        MemorandumDate memorandumDate = new MemorandumDate();
        memorandumDate.deleteMemorandum(1, 1);
    }
    @Test
    public void testUpdateMemorandum() {
     
        Map<String, String> map = new HashMap<>();
        map.put("标题", "bb");
        map.put("内容", "bbbb");
        MemorandumDate memorandumDate = new MemorandumDate();
        memorandumDate.updateMemorandum(1, 2, map);
    }
    
    @Test
    public void testGetMemorandum() {
        
        MemorandumDate memorandumDate = new MemorandumDate();
        List<Memorandum> list = memorandumDate.getMemorandum(1);
        for (Memorandum memorandum : list) {
            System.out.println(memorandum.getMemorandum_id());
        }
    }

}
