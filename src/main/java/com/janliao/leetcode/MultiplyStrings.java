package com.janliao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "9";
        String num2 = "9";
        String res = new MultiplyStrings().multiply(num1, num2);
        System.out.println(res);
    }

    public String multiply(String num1, String num2) {
        if(num1.charAt(0) == '0' || num2.charAt(0) == '0') return "0";
        StringBuilder sb = new StringBuilder();
        if("".equals(num1.trim())) {
            for(int i = 0, l = num2.length() - 1; i < l; i++){
                sb.append("0");
            }
            return sb.toString();
        }
        if("".equals(num2.trim())){
            for(int i = 0, l = num1.length() - 1; i < l; i++){
                sb.append("0");
            }
            return sb.toString();
        }
        int lens1 = num1.length();
        int lens2 = num2.length();
        if(lens2 > lens1){
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        List<int[]> list = new ArrayList<>();
        int len1 = num1.length();
        int len2 = num2.length();
        for(int i = len2 - 1; i >= 0; i--){
            int[] arr = mul(num1, num2.charAt(i), len2 - 1 - i, len1 + len2);
            list.add(arr);
        }
        int pre = 0;
        for(int i = len1 + len2 - 1; i >= 0; i--){
            int sum = pre;
            for(int[] arr : list){
                sum += arr[i];
            }
            pre = sum / 10;
            sb.append(sum % 10);
        }
        String res = sb.reverse().toString();
        int idx = -1;
        for(int i = 0; i < res.length(); i++){
            if(res.charAt(i) == '0'){
                idx = i;
            } else{
                break;
            }
        }
        return idx == -1 ? res : res.substring(idx + 1);
    }

    private int[] mul(String num1, char c, int offset, int lens) {
        int[] arr = new int[lens];
        int idx = lens - 1 - offset;
        int pre = 0;
        int len = num1.length();
        int id = len - 1;
        while(id >= 0){
            int a = num1.charAt(id--) - '0';
            int b = c - '0';
            int s = a * b + pre;
            pre = s / 10;
            arr[idx--] = s % 10;
        }
        arr[idx] = pre;
        return arr;
    }
}
