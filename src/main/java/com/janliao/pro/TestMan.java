package com.janliao.pro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

class M{
    private int age;

    public int dpt;

    @Override
    public String toString() {
        return "M{" +
                "age=" + age +
                ", dpt=" + dpt +
                '}';
    }
}
public class TestMan {
    public static void main(String[] args) {
        double aa = 2.1;
        double bb = 2.1000;
        System.out.println(aa == bb);
//        File file = new File("");
//        try {
//            FileReader fr = new FileReader(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        process();
    }

    private static void process() {
        M m = new M();
        m.dpt = 8;
        int a = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                //m = new M();
                m.dpt = 10;
                System.out.println(m);
            }
        }).start();
    }
}
