package com.janliao.janproxy;

public class MyTarget implements Target {
    @Override
    public void test(String msg) {
        System.out.println("target = " + msg);
    }
}
