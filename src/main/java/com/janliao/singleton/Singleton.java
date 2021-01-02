package com.janliao.singleton;

public class Singleton {
    private static volatile Singleton single = null;

    private int a = 0;

    private Singleton() {

    }

    private Singleton(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public static Singleton getInstance() {
        if (single == null) {
            synchronized (Singleton.class) {
                if (single == null) {
                    single = new Singleton(6);
                }
            }
        }
        return single;
    }
}
