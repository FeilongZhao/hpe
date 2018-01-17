package com.hpe.test;

import org.junit.Test;

import com.hpe.po.Memorandum;
import com.hpe.view.MemorandumView;

public class TestMemorandumView {
    
    
    @Test
    public void main() {
        MemorandumView mView = new MemorandumView();
        mView.updateMemorandumView();
    }

}
