package com.janliao.leetcode;

public class LongestValidParentheses3 {
    public static void main(String[] args) {
        String s = "()(()";
        s = "(())((()";
        int res = new LongestValidParentheses3().longestValidParentheses(s);
        System.out.println(res);
    }

    public int longestValidParentheses(String s){
        int lens = s.length();
        if(lens == 0 || lens == 1) return 0;
        int max = 0;
        int[] arr = new int[lens];
        for(int i = 1; i < lens; i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i - 1) == '('){
                    arr[i] = (i >= 2 ? arr[i - 2] : 0) + 2;
                } else if((i - arr[i - 1]) > 0 && s.charAt(i - arr[i - 1] - 1) == '('){
                    arr[i] = arr[i - 1] + (i - arr[i - 1] >= 2 ?
                            arr[i - arr[i - 1] - 2] : 0) + 2;
                }
            }
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public int longestValidParentheses1(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        for(int i = 0; i < s.length(); i++){
            System.out.print(dp[i] + "\t");
        }
        System.out.println();
        return maxans;
    }
}
