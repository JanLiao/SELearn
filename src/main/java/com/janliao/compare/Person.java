package com.janliao.compare;

import java.util.*;

public class Person implements Comparable<Person> {
    private int age;

    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
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
    public int compareTo(Person o) {
        return (this.age - o.age);
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        Person p1 = new Person(1, "jan");
        Person p2 = new Person(3, "fang");
        Person p3 = new Person(2, "jf");
        list.add(p1);
        list.add(p2);
        list.add(p3);
        Collections.sort(list);
        for (Person p : list) {
            System.out.println(p);
        }
        Map<String, Person> map = new HashMap<>();
        map.put("jan", p1);
        map.put("fang", p2);
        map.put("jf", p3);
        //Set<Map.Entry<String, Person>> entry = map.entrySet();
        //Arrays.sort(entry.toArray());
        Set<String> set = map.keySet();
        Object[] str = set.toArray();
        Arrays.sort(str);
        for (Object s : str) {
            System.out.println(s + " = " + map.get(s));
        }
        List<Map.Entry<String, Person>> entry = new ArrayList<>(map.entrySet());
        Collections.sort(entry, new Comparator<Map.Entry<String, Person>>() {
            @Override
            public int compare(Map.Entry<String, Person> o1, Map.Entry<String, Person> o2) {
                return (o1.getValue().getAge() - o2.getValue().getAge());
            }
        });
        for (Map.Entry<String, Person> en : entry) {
            System.out.println(en.getKey() + " = " + en.getValue());
        }
    }
}
