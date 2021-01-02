package com.janliao.pro;

import com.janliao.pro.entity.Humen;

public class TestHuman {
    public static void main(String[] args) {
        process();
    }

    private static void process() {
        Humen h = new Humen();
        h.dpt = 5;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                h.dpt = 9;
                System.out.println(h);
            }
        }).start();
        h.dpt = 8;
    }
}
