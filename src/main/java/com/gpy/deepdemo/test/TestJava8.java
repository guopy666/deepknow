package com.gpy.deepdemo.test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Description:
 * @Author: gpy
 * @CreateDate: 2019/2/20 14:22
 * @Version: 1.0.0
 */
public class TestJava8 {
    public static void main1(String[] args)
    {
        Map<String,String> map = new HashMap<String,String>();//new HashMap<String,String>();
        for (int i = 1; i <=30; i++)
        {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());

    }
}
