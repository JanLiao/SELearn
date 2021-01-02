package com.janliao.leetcode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        // asdbuiodevauufgh
        int len = process(s);
        System.out.println(len);
    }

    private static int process(String str) {
        if("".equals(str) || str == null) return 0;
        String pattern = "aeiouAEIOU";
        int idx = 0;
        int max = 0;
        int curLen = 0;
        for(int i = 0, lens = str.length(); i < lens; i++){
            char c = str.charAt(i);
            if(pattern.contains("" + c)){
                curLen++;
            } else{
                //System.out.println(curLen);
                if(curLen > max){
                    max = curLen;
                }
                curLen = 0;
            }
        }
        if(curLen > max){
            max = curLen;
        }
        return max;
    }
}
