package com.janliao.compare;

import org.ho.yaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Student1{
    private int age;
    private String name;
    private List<String> list;
    private Map<String, String> map;
    private Person p;

    public Student1() {
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

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }
}

public class YamlTest {
    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(50);
        p.setName("jan");
        Student1 s = new Student1();
        s.setAge(20);
        s.setName("jj");
        List<String> list = new ArrayList<>();
        list.add("ab");list.add("cd");
        Map<String, String> map = new HashMap<>();
        map.put("jan", "jj");map.put("fang", "sf");
        s.setP(p);
        s.setList(list);
        s.setMap(map);
        File file = new File("F:\\Intellij Project\\SELearn\\src\\main\\java\\com\\janliao\\compare\\a.yaml");
        try {
            Yaml.dump(s, file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}