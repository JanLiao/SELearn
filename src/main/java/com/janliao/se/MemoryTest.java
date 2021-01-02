package com.janliao.se;

public class MemoryTest {
    private int a = 0;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "MemoryTest{" +
                "a=" + a +
                '}';
    }

    public static void main(String[] args) throws InterruptedException {
        MemoryTest mt = new MemoryTest();
        mt.setA(5);
        MyRunnable m = new MyRunnable();
        m.setMt(mt);
        new Thread(m).start();
        while (true) {
            System.out.println(mt);
            Thread.sleep(2000);
        }
    }
}

class MyRunnable implements Runnable {
    private MemoryTest mt;

    public MemoryTest getMt() {
        return mt;
    }

    public void setMt(MemoryTest mt) {
        this.mt = mt;
    }

    @Override
    public String toString() {
        return "MyRunnable{" +
                "mt=" + mt +
                '}';
    }

    @Override
    public void run() {
        System.out.println(mt);
        mt.setA(9);
        System.out.println(mt);
    }
}