package com.janliao.compare;


class MyException extends Exception{
    private String s;
    public MyException(String s){
        this.s = s;
    }
    public String toString(){
        return this.s;
    }
}
public class TestP {
    public void test1(){
        try{
            System.out.println("--------");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("test1");
        }
    }

    public static void test(){
        try{
            System.out.println("=========");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("test");
        }
    }

    public static void test3(){
        int a = 0;
        System.out.println(4 / a);
    }

    public static void test2() throws MyException {
        int a = 0;
        if(a == 0){
            throw new MyException(" = is 0!");
        }
        test3();
    }

    public static void main(String[] args) throws Exception {
        test();
        new TestP().test1();
        test2();
    }
}
