package com.janliao.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s = "bcab";
        String res = new RemoveDuplicateLetters().removeDuplicateLetters(s);
        System.out.println(res);
    }

    public String removeDuplicateLetters(String s) {
        int lens = s.length();
        if(lens == 0 || lens == 1) return s;
        int[] last = lastIdx(s);
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < lens; i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                continue;
            }
            while(!stack.isEmpty()
                    && (stack.peek() > c)
                    && last[stack.peek() - 'a'] > i){
                set.remove(stack.pop());
            }
            set.add(c);
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public int[] lastIdx(String s){
        int[] idx = new int[26];
        for(int i = 0, lens = s.length(); i < lens; i++){
            idx[s.charAt(i) - 'a'] = i;
        }
        return idx;
    }
}
