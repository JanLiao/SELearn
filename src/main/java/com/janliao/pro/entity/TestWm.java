package com.janliao.pro.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestWm {
    public static void main(String[] args) {
        Woman w = new Woman();
        w.setAge(5);
        System.out.println(w);
        Map<String, String> map = new LinkedHashMap<>();
        map.put("", "");
        ArrayList<String> list = new ArrayList<>();
        list.add("");
        list.add(null);
        for(String s : list){
            list.remove(s);
            System.out.println();
        }
        Iterator<String> ite = list.iterator();
        ite.hasNext();
    }
}
