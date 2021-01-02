package com.janliao.functionTest;

import java.util.function.Consumer;

//interface InterfaceTest {
//    public void test1();
//
////    public void test2();
//}

public class TestInterface {
    public static void main(String[] args) {
        Consumer f = System.out::println;
        Consumer f1 = (o) -> {
            System.out.println(o + " = test ");
        };
        f.accept("t");
    }
}
