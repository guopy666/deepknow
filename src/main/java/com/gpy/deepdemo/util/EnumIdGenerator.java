package com.gpy.deepdemo.util;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/9/4 14:56
 * @version: v1.0.0
 */
public enum  EnumIdGenerator {

    INSTANCE;

    private AtomicLong id = new AtomicLong(0);

    public long getId(){
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        long id = EnumIdGenerator.INSTANCE.getId();
        long id1 = EnumIdGenerator.INSTANCE.getId();
        System.out.println(id);
        System.out.println(id1);
    }

}