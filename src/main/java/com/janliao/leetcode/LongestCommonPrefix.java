package com.janliao.leetcode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] str = new String[]{"flower", "flower", "fliower"};
        String res = new LongestCommonPrefix().longestCommonPrefix(str);
        System.out.println(res);
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs.length == 1) return "";
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for(int i = 0; i < strs.length; i++){
            if(strs[i].length() < min){
                min = strs[i].length();
                idx = i;
            }
        }
        if(min == 0) return "";
        String tmp = strs[idx];
        int lens = tmp.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < lens; i++){
            boolean flag = true;
            for(int j = 0, len = strs.length; j < len; j++){
                if(tmp.charAt(i) != strs[j].charAt(i)){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                sb.append(tmp.charAt(i));
            } else{
                break;
            }
        }
        return sb.toString();
    }
}
