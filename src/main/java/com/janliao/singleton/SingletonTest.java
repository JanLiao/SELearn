package com.janliao.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton single = Singleton.getInstance();
        System.out.println(single.getA());

        single.setA(5);

        Singleton single1 = Singleton.getInstance();
        System.out.println(single1.getA());
    }
}
