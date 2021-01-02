package com.janliao.leetcode;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String str = "(()[])";
        boolean flag = new ValidParentheses().isValid(str);
        System.out.println(flag);
    }

    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        if(s.length() == 1) return false;
        Stack<Character> stack = new Stack<>();
        label:
        for(int i = 0, lens = s.length(); i < lens; i++){
            char c = s.charAt(i);
            if(c == ')' || c == ']' || c == '}'){
                if(stack.isEmpty()){
                    stack.push(c);
                    break;
                }
                while(!stack.isEmpty()){
                    char tp = stack.peek();
                    if(tp == ')' || tp == '}' || tp == ']') break label;
                    if(c == ')' && tp == '('){
                        stack.pop();
                        break;
                    }
                    if(c == '}' && tp == '{'){
                        stack.pop();
                        break;
                    }
                    if(c == ']' && tp == '['){
                        stack.pop();
                        break;
                    }
                    break label;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
