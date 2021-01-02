package com.janliao.compare;

import java.util.*;

public class TestComparator {
    public static void main(String[] args) {
        Vector<String> vec = new Vector<>();
        Stack<String> stack = new Stack<>();
        //Collections.synchronizedList(null);
        Student s1 = new Student(2, "jan");
        Student s2 = new Student(1, "fang");
        Student s3 = new Student(3, "fj");
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        Comparator com = new MyComparator();
        Collections.sort(list, com);
        for (Student s : list) {
            System.out.println(s);
        }
        list.forEach((anyThing)->System.out.println(anyThing));
        System.out.println("--------");
        list.forEach(System.out::println);
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("", "");
        map.entrySet().iterator();
        int[] arr = {1, 2};
        List<Object> al = Arrays.asList(arr);
        // al.add(5);
        final int a = 0;
        String b = "1";
        new Thread(new Runnable(){

            @Override
            public void run() {
                int c = a;
                System.out.println(a);
            }
        }).start();
    }
}
