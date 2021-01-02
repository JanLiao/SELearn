package com.janliao.compare;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

interface IPs{
    public int age = 5;
    public void test();
    public static void test1(){
        System.out.println("---------");
    }
}
abstract class Ps{
    public static final void test(){
        System.out.println();
    }
    public abstract void test1();
    public abstract void test2();
}
public class TestInterface implements IPs {
    private final int age = 0;
    @Override
    public void test() {
        System.out.println("=======");
    }

    public static void main(String[] args) {
        TestInterface ti = new TestInterface();
        System.out.println(ti.age);
        IPs.test1();
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(1, 2,
                10, TimeUnit.MINUTES, new ArrayBlockingQueue<>(100),
                new ThreadPoolExecutor.AbortPolicy());
        new ArrayList<>();
    }
}
