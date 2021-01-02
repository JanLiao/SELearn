package com.janliao.leetcode;

public class StringtoInteger {
    public static void main(String[] args) {
        String s = "+1";
        //s = "words and 987";
        String t = s;
        String t1 = "a";
        t = t + t1;
        System.out.println(s + ", " + t.hashCode());
        String cs = "+1c";
        System.out.println(cs.hashCode());
        int res = new StringtoInteger().myAtoi(s);
        System.out.println("res = " + res);
    }

    public int myAtoi(String str) {
        str = str.trim();
        if("".equals(str)) return 0;
        if(str.charAt(0) == '-'){
            int offset = checkStr(str.substring(1));
            if(offset != -1){
                return reverse(str.substring(0, offset + 2));
            }
        } else if(str.charAt(0) == '+'){
            int offset = checkStr(str.substring(1));
            //System.out.println(offset);
            if(offset != -1){
                return reverse(str.substring(1, offset + 2));
            }
        } else{
            int offset = checkStr(str);
            //System.out.println(offset);
            if(offset != -1){
                return reverse(str.substring(0, offset + 1));
            }
        }
        return 0;
    }

    public int checkStr(String s){
        int sum = -1;
        for(int i = 0, lens = s.length(); i < lens; i++){
            if(s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9){
                sum++;
            } else{
                break;
            }
        }
        return sum;
    }

    public int reverse(String s){
        boolean flag = false;
        int idx = 0;
        int sum = 0;
        if(s.charAt(0) == '-'){
            flag = true;
            idx = 1;
            sum = '0' - s.charAt(idx);
        } else{
            sum = s.charAt(idx) - '0';
        }
        idx++;
        int lens = s.length();
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        while(idx < lens){
            int num = -1;
            if(idx <= lens - 1){
                num = s.charAt(idx) - '0';
            }
            //System.out.println("sum = " + sum + ", " + num);
            if(sum > max / 10 || (sum == max / 10 && num > 7)){
                return 2147483647;
            } else if(sum < min / 10 || (sum == min / 10 && num > 8)){
                return -2147483648;
            }
            int offset = s.charAt(idx) - '0';
            if(flag) sum = sum * 10 - offset;
            else sum = sum * 10 + offset;
            idx++;
        }
        return sum;
    }
}
