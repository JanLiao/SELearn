package com.janliao.compare;

import java.io.File;

class Paren{
    public static final String foo = "ODD";
    public static String fo = "OEE";
}
public class Sub extends Paren{
    public static final String foo = "OSS";
    public static String fo = "OFF";

    public static void main(String[] args) {
        System.out.println(File.separator);
        Thread.yield();
        Paren p = new Paren();
        Sub s = new Sub();
        System.out.println(p.foo);
        System.out.println(s.foo);
        p = s;
        System.out.println(p.foo);
        System.out.println(Paren.fo);
        System.out.println(Sub.fo);
    }
}
