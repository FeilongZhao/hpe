package com.hpe.test;

import org.junit.Test;

import com.hpe.vo.PersonalVo;

public class TestPersonVo {

    @Test
    public void testMain() {
        
        PersonalVo personalVo = new PersonalVo();
        personalVo.main(1);
    }
}
