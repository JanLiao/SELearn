package com.janliao.compare;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class StringTest {
    public static void main(String[] args) {
        String s = "jan";
        String t = new String("jan");
        System.out.println(s.hashCode());
        System.out.println(t.hashCode());
        ok:
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.println(i + " = " + j);
                if(j == 5){
                    break ok;
                }
            }
        }
        System.out.println("000000000000");
        TreeMap<String, String> tree = new TreeMap<>();
        tree.put("", "");
        TreeSet<String> set = new TreeSet<>();
        set.add("");
    }
}
