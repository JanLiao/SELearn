package com.janliao.leetcode;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = "()(()";
        int res = new LongestValidParentheses().longestValidParentheses(s);
        System.out.println(res);
    }

    public int longestValidParentheses(String s) {
        if(s.length() == 0 || s.length() == 1) return 0;
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[s.length()];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0, lens = s.length(); i < lens; i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            } else {
                if(stack.isEmpty()){
                    stack.push(i);
                } else {
                    char tp = s.charAt(stack.peek());
                    if(c == ')' && tp == '('){
                        arr[i] = 1;
                        arr[stack.pop()] = 1;
                    } else {
                        stack.push(i);
                    }
                }
            }
        }
        for(int i = 0, lens = s.length(); i < lens; i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        for(int i = 0, lens = s.length(); i < lens; i++){
            if(arr[i] == 1){
                sum++;
            } else {
                max = Math.max(sum, max);
                sum = 0;
            }
        }
        // 会出现最后max遗留问题
        max = Math.max(sum, max);
        return max;
    }
}
