package com.janliao.leetcode;

import java.util.Stack;

public class LongestValidParentheses1 {
    public static void main(String[] args) {
        String s = "()(()";
        int res = new LongestValidParentheses1().longestValidParentheses(s);
        System.out.println(res);
    }

    public int longestValidParentheses(String s) {
        if (s.length() == 0 || s.length() == 1) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for(int i = 0, lens = s.length(); i < lens; i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
