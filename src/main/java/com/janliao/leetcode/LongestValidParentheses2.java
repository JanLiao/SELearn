package com.janliao.leetcode;

import java.util.Stack;

public class LongestValidParentheses2 {
    public static void main(String[] args) {
        String s = "()(()";
        //s = "))()()";
        int res = new LongestValidParentheses2().longestValidParentheses(s);
        System.out.println(res);
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.pop();
        int a = Integer.parseInt("2147483660");
        System.out.println(a);
    }

    public int getV(){
        return -1;
    }

    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}
