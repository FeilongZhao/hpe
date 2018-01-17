package com.hpe.test;

import org.junit.Test;

import com.hpe.view.GameShowView;

public class TestGameView {

    @Test
    public void tsetMain() {
        
       GameShowView gameShowView = new GameShowView();
       gameShowView.rankingView();
    }
}
