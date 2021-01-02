package com.janliao.pro;

interface MyInterface {
    void doSomething();
}
public class TryUsingAnonymousClass {
    public void useMyInterface() {
        final Integer number = 123;
        System.out.println(number);

        MyInterface myInterface = new MyInterface() {
            @Override
            public void doSomething() {
                System.out.println(number);
            }
        };
        myInterface.doSomething();

        System.out.println(number);
    }
}
