package com.hpe.test;

import org.junit.Test;

import com.hpe.view.AccountView;

public class TsetAccountView {
    
    @Test
    public void testMain() {
        
        AccountView aView = new AccountView();
        aView.updatePasswordView();
    }

}
