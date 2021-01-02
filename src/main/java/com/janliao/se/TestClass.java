package com.janliao.se;

import java.util.List;

public class TestClass {
    static {
        b = 9;
    }

    static int b = 1;
    private int a;

    public int inc() {
        return a + 1;
    }

//    public void inc(){
//        System.out.println("----------");
//    }

//    public List<Integer> inc (){
//        System.out.println("==============");
//    }

    public int ret() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            System.out.println("zhixing");
            x = 3;
        }
    }

    public static void main(String[] args) {
        TestClass tc = new TestClass();
        System.out.println(tc.ret());
    }
}
