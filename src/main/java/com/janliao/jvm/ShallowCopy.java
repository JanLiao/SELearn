package com.janliao.jvm;

public class ShallowCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Head head = new Head(50);
        Person p = new Person(10, "jan");
        p.setHead(head);
        Person p1 = p.clone();
        System.out.println(p1);
        p1.getHead().setHeight(80);
        System.out.println(p);
    }
}
