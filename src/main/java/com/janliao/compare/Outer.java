package com.janliao.compare;

interface NoName{
    public void test();
}

class Pst{

}

public class Outer {
    // 成员内部类
    private class Inner{
        public void test(){
            System.out.println("============");
        }
    }

    // 静态内部类
    private static class Inner1{
        public void test(){
            System.out.println("-------------");
        }
    }

    public void test(){
        Pst p = new Pst();
        // 局部内部类
        class Inner2{
            public void test(){
                System.out.println(p);
                System.out.println("-=-=-=-=-=-=-=");
            }
        }
        System.out.println(p);
        Inner2 inner2 = new Inner2();
        inner2.test();
    }

    public NoName getNoName(){
        // 匿名内部类
        return new NoName() {
            @Override
            public void test() {
                System.out.println("------------ no-name");
            }
        };
    }

    public static void main(String[] args) {
        // 成员内部类实例化
        Outer out = new Outer();
        Inner inner = out.new Inner();
        inner.test();
        // 静态内部类实例化
        Inner1 inner1 = new Outer.Inner1();
        inner1.test();
        NoName no = out.getNoName();
        no.test();
    }
}
