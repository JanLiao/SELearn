package com.janliao.leetcode;

public class TestStr {
    public static void main(String[] args) {
        String s = "wfsdfsd";
        int i = 0;
        while(i < s.length()){
            System.out.println(s.charAt(i++));
            s += i;
        }
    }
}
