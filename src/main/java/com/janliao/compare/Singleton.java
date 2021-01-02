package com.janliao.compare;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Singleton {
    // 方式一,饥汉模式
    private static Singleton single = new Singleton();
    // 方式二,懒汉模式
    private static Singleton single1;
    // 方式三,双重检查模式
    private static volatile Singleton single2;
    // 方式四,内部类模式,内部类加载保证线程安全
    private static class SingletonHold{
        public static Singleton singleton = new Singleton();
    }

    // 方式四
    public static Singleton getInstance(){
        return SingletonHold.singleton;
    }

    // 方式一
    public static Singleton getInstance1(){
        return single;
    }

    // 方式二
    public static Singleton getInstance2(){
        if(single1 == null) {
            single1 = new Singleton();
        }
        return single1;
    }

    // 方式三
    public static Singleton getInstance3(){
        if(single2 == null){
            synchronized(Singleton.class){
                if(single2 == null){
                    single2 = new Singleton();
                }
            }
        }
        return single2;
    }

    public static void main(String[] args) {
        Executors.newFixedThreadPool(5);
        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();
        ExecutorService executor = Executors.newScheduledThreadPool(6);
        //executor.submit();
        //executor.execute();
    }
}
