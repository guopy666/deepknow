package com.gpy.deepdemo.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description:
 * @author: guopy
 * @Date: 2020/9/4 14:19
 * @version: v1.0.0
 */
public class IdGenerator {



    //饿汉式单例模式
    /*private AtomicLong id = new AtomicLong(0);

    private static IdGenerator instance = new IdGenerator();

    private IdGenerator(){

    }
    public static IdGenerator getInstance(){
        return instance;
    }

    public long getId(){
        return id.incrementAndGet();
    }
*/

    //懒汉式单例模式
    /*private AtomicLong id = new AtomicLong(0);

    private static IdGenerator instance;

    private IdGenerator(){

    }
    public static synchronized IdGenerator getInstance(){
        if (null == instance){
            instance = new IdGenerator();
        }
        return instance;
    }
    public long getId(){
        return id.incrementAndGet();
    }*/

    //双重检测
    /*private AtomicLong id = new AtomicLong(0);

    private static IdGenerator instance;

    private IdGenerator(){

    }

    public IdGenerator getInstance(){
        if (instance == null){
            synchronized (IdGenerator.class){//加类级别的锁
                if (instance == null){
                    instance = new IdGenerator();
                }
            }
        }
        return instance;
    }
    public long getId(){
        return id.incrementAndGet();
    }*/


    /*//静态内部类实现单例
    private AtomicLong id = new AtomicLong(0);

    private IdGenerator(){

    }

    public static class SingletonHolder{
        private static final IdGenerator instance = new IdGenerator();
    }

    public static IdGenerator getInstance(){
        return SingletonHolder.instance;
    }

    public long getId(){
        return id.incrementAndGet();
    }*/

    //通过HashMap实现线程内唯一，线程间不唯一的对象
    private AtomicLong id = new AtomicLong(0);
    private static final ConcurrentHashMap<Long, IdGenerator> instances = new ConcurrentHashMap<>();

    private IdGenerator(){

    }

    public static IdGenerator getInstance(){
        long currentThreadId = Thread.currentThread().getId();
        instances.putIfAbsent(currentThreadId,new IdGenerator());
        return instances.get(currentThreadId);
    }

    public long getId(){
        return id.incrementAndGet();
    }






    public static void main(String[] args) {
        long id = IdGenerator.getInstance().getId();

        long id1 = IdGenerator.getInstance().getId();
        System.out.println(id);
        System.out.println(id1);
    }
}