package com.janliao.leetcode;

import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        String s = "2-11 + 20";
        //int res = new Calculator().calculate(s);
        //System.out.println(res);
        String ss = "9 - ((3 - 9) + (2 + 3))";
        ss = ss.replaceAll(" ", "");
        System.out.println(ss);
        //int start = 2;
        //int end = 6;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < ss.length(); i++){
            if(ss.charAt(i) == '('){
                stack.push(i);
            } else if(ss.charAt(i) == ')') {
                int start = stack.pop();
                int end = i;
                if(start > 0 && ss.charAt(start - 1) == '-'){
                    String tp1 = ss.substring(0, start);
                    //String tp2 = ss.substring(start + 1, end);
                    //System.out.println(tp1 + ", " + tp2);
                    String tp2 = (end < ss.length() - 1 ? ss.substring(end + 1) : "");
                    StringBuilder tp3 = new StringBuilder();
                    tp3.append(" ");
                    for(int j = start + 1; j < end; j++){
                        if(ss.charAt(j) == '+'){
                            tp3.append('-');
                        } else if(ss.charAt(j) == '-'){
                            tp3.append('+');
                        } else {
                            tp3.append(ss.charAt(j));
                        }
                    }
                    tp3.append(" ");
                    ss = tp1 + tp3 + tp2;
                } else {
                    String tp1 = ss.substring(0, start);
                    String tp2 = ss.substring(start + 1, end);
                    System.out.println(tp1 + ", " + tp2);
                    String tp3 = (end < ss.length() - 1 ? ss.substring(end + 1) : "");
                    ss = tp1 + " " + tp2 + tp3 + " ";
                }
            }
        }
        System.out.println(ss);
    }
    public int calculate(String s) {
        int lens = s.length();
        if(lens == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        s = s.replaceAll(" ", "");
        for(int i = 0; i < lens; i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            } else if(s.charAt(i) == ')') {
                int start = stack.pop();
                if(start > 0 && s.charAt(start - 1) == '-'){

                } else {

                }
            }
        }
        return cal(s);
    }
    public int cal(String s){
        int lens = s.length();
        int sum = 0;
        int flag = 1;
        int tmp = 0;
        int i = 0;
        while(i < lens){
            if(s.charAt(i) == '(' || s.charAt(i) == ')' ||
                    s.charAt(i) == ' '){
                i++;
            } else if(s.charAt(i) == '+'){
                flag = 1;
                i++;
            } else if(s.charAt(i) == '-'){
                flag = 0;
                i++;
            } else {
                while(i < lens){
                    if(checkChar(s.charAt(i))){
                        //i--;
                        break;
                    } else {
                        tmp = tmp * 10 + Integer.parseInt("" + s.charAt(i));
                        System.out.println("i = " + i + ",tmp = " + tmp);
                        i++;
                    }
                }
                if(flag == 0){
                    sum = minusNum(sum, tmp);
                    tmp = 0;
                } else if(flag == 1) {
                    sum = addNum(sum, tmp);
                    tmp = 0;
                }
            }
        }
        return sum;
    }
    public boolean checkChar(char c){
        if(c == ' ' || c == '(' ||
                c == ')' || c == '+' ||
                c == '-'){
            return true;
        }
        return false;
    }
    public int addNum(int a, int b){
        return a + b;
    }
    public int minusNum(int a, int b){
        return a - b;
    }
}
