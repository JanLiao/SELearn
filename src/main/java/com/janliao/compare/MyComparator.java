package com.janliao.compare;

public class MyComparator implements java.util.Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return (o1.getAge() - o2.getAge());
    }
}
