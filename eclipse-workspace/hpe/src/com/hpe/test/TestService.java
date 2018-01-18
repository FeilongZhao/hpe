package com.hpe.test;

import java.math.BigDecimal;

import org.junit.Test;

import com.hpe.service.WallentService;

public class TestService {
    
    
    @Test
    public void testService() {
        
        WallentService wallentService = new WallentService();
        wallentService.savaMoney(new BigDecimal("12"));
        
    }

}
