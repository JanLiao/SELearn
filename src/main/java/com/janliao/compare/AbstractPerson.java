package com.janliao.compare;

public abstract class AbstractPerson implements IPerson {
    private int age;
    public AbstractPerson(){
        this.age = 5;
    }
    public void test(){
        System.out.println("============");
    }
}
