package com.janliao.leetcode;

import sun.misc.Unsafe;

import java.util.concurrent.CountDownLatch;

public class TestVolatile {
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private volatile int num = 0;
    private static final long valueOffset;
    static {
        try {
            valueOffset = unsafe.objectFieldOffset
                    (TestVolatile.class.getDeclaredField("num"));
        } catch (Exception ex) { throw new Error(ex); }
    }
    public static void main(String[] args) {
        new TestVolatile().test();
    }

    private void test() {
        int nn = 3;
        CountDownLatch cdl = new CountDownLatch(nn);
        for(int i = 0; i < nn; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i < 1000000; i++){
                        while(true){
                            int cur = getNum();
                            int next = cur + 1;
                            if(compareAndSet(cur, next)){
                                break;
                            }
                        }
                    }
                    cdl.countDown();
                }
            }).start();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getNum());
    }

    private boolean compareAndSet(int cur, int next){
//        if(getNum() == cur){
//            num = next;
//            return true;
//        }
//        return false;
        return unsafe.compareAndSwapInt(this, valueOffset, cur, next);
    }

    private int getNum(){
        return num;
    }
}
