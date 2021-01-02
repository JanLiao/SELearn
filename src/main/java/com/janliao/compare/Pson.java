package com.janliao.compare;

interface IStudent{
    public void test();
}

abstract class AbstractStudent implements IStudent{
    public void test1(){
        System.out.println("============");
    }

    public void test(){
        System.out.println("------------");
    }
}

class Student2 extends AbstractStudent{
    private String name;
    public int age;
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
}
public class Pson extends Student2{
    public String getName(){
        return "p = " + super.getName();
    }
    public int getAge(){
        return this.age;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(arr.length);
        int[] arr1 = {1};
        int[][] arr2 = {{1,2}, {2,3}};
        int[][] arr3 = new int[][]{{1,2}, {23,3}};
        Pson p = new Pson();
        p.setName("jan");
        p.setAge(5);
        System.out.println(p.getName());
        System.out.println(p.getAge());
    }
}
