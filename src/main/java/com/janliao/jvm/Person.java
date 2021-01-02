package com.janliao.jvm;

public class Person implements Cloneable {
    private Head head;

    private int age;

    private String name;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "head=" + head +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
}
