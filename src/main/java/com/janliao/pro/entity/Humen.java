package com.janliao.pro.entity;

public class Humen {
    private int age;

    String name;

    protected String psw;

    public int dpt;

    @Override
    public String toString() {
        return "Humen{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", psw='" + psw + '\'' +
                ", dpt=" + dpt +
                '}';
    }
}
