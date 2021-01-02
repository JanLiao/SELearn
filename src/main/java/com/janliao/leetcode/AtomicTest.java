package com.janliao.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    private static AtomicInteger ai = new AtomicInteger();
    private AtomicInteger aa = new AtomicInteger();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i = 0; i < 10000; i++){
                    ai.incrementAndGet();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i = 0; i < 10000; i++){
                    ai.incrementAndGet();
                    ai.getAndIncrement();
                }
            }
        }).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ai.get());
        
        new AtomicTest().test();
    }

    private void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                aa.getAndIncrement();
            }
        }).start();
        int a = 0;
        new Runnable(){

            @Override
            public void run() {
                System.out.println(a);
                aa.getAndIncrement();
            }
        };
    }
}
