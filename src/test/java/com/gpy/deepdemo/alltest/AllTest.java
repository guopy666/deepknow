package com.gpy.deepdemo.alltest;

import org.junit.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @Description:
 * @author: guopy
 * @Date: 2019/4/10 09:52
 * @version: v1.0.0
 */
@SpringJUnitConfig
public class AllTest {

    @Test
    public void testYear(){
        System.out.println(LocalDateTime.now().getYear());
    }


    @Test
    public void testRandom2(){
        int i = new Random().nextInt(9);
        String newString = String.format("%0"+2+"d", i);
        System.out.println(newString);
    }

    @Test
    public void testSubstring(){
        String string = "1.0ETS_120 00000000";
        String substring = string.substring(3, 11);
        System.out.println(substring);
    }
}