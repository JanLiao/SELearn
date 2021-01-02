package com.janliao.leetcode;

import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantLock;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "aaaabaaa";
        //System.out.println(s.substring(0, s.length()));
        String res = new LongestPalindromicSubstring().longestPalindrome(s);
        System.out.println(res);
        ReentrantLock lock = new ReentrantLock();
        //System.out.println(new LongestPalindromicSubstring().longestPalindrom(s));
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        tree.put(1, 4);
        tree.put(10, 3);
        tree.put(5, 4);
        tree.put(0, 4);
//        Set<Integer> set = tree.keySet();
//        for(int i : tree.keySet()){
//            System.out.println(i);
//        }
    }

    public String longestPalindrome(String s) {
        int lens = s.length();
        if (lens == 0 || lens == 1) return s;
        // 字符预处理
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for(int i = 0; i < lens; i++){
            sb.append(s.charAt(i));
            sb.append('#');
        }
        String s1 = sb.toString();
        //System.out.println(s1);
        lens = s1.length();
        // 回文中心下标
        int c = 0;
        // 最长回文长度
        int max = 0;
        int mc = 0;
        // 回文右边界
        int r = 0;
        int[] arr = new int[lens];
        for(int i = 0; i < lens; i++){
            arr[i] = i < r ? Math.min(arr[2 * c - i], r - i) : 1;
            while((i + arr[i] < lens) && (i - arr[i] >= 0) &&
                    (s1.charAt(i + arr[i]) == s1.charAt(i - arr[i]))){
                arr[i] += 1;
            }
            if(r < (i + arr[i] - 1)){
                r = i + arr[i] - 1;
                c = i;
            }
            if(max < arr[i]){
                max = arr[i] - 1;
                mc = i;
            }
        }
        //System.out.println(c + " = " + r + " = " + mc + " = " + max);
        String res = s1.substring(mc - max + 1, mc + max);
        res = res.replaceAll("#", "");
        return res;
    }

    public String longestPalindrome5(String s) {
        int lens = s.length();
        if (lens == 0 || lens == 1) return s;
        String res = s.substring(0, 1);
        int i = 1;
        String tmp = "";
        String tmp1 = "";
        while(i < lens){
            // 判断该字符是否与前字符相同, 分两种情况分别处理
            if(s.charAt(i) == s.charAt(i - 1)){
                tmp = checkLeftRightStr(i, i, lens, s);
                tmp1 = checkLeftRightStr(i - 1, i, lens, s);
            } else {
                tmp = checkLeftRightStr(i, i, lens, s);
            }
            res = tmp.length() > res.length() ? tmp : res;
            res = tmp1.length() > res.length() ? tmp1 : res;
            i++;
        }
        return res;
    }

    public String checkLeftRightStr(int i, int j, int lens, String s){
        String res = s.substring(i, j + 1);
        i--;
        j++;
        //System.out.println(i + " = " + j);
        while(i >= 0 && j < lens){
            if(s.charAt(i) == s.charAt(j)){
                res = s.substring(i, j + 1);
            } else {
                break;
            }
            i--;
            j++;
            //System.out.println(i + " = " + j);
        }
        return res;
    }

    public String longestPalindrome4(String s) {
        int lens = s.length();
        if (lens == 0 || lens == 1) return s;
        int start = 0;
        int len = 1;
        // 数组用于标识下标起止子字符串是否回文字符
        int[][] arr = new int[lens][lens];
        for(int i = 0; i < lens; i++){
            arr[i][i] = 1;
            if((i + 1) < lens){
                if(s.charAt(i) == s.charAt(i + 1)){
                    start = i;
                    arr[i][i + 1] = 1;
                    len = 2;
                }
            }
        }
        // 动态求出最长回文子串
        for(int i = 3; i <= lens; i++){
            for(int j = 0; j <= lens - i; j++){
                if(s.charAt(j) == s.charAt(j + i - 1) && (arr[j + 1][j + i - 2] == 1)){
                    arr[j][j + i - 1] = arr[j + 1][j + i - 2];
                    start = j;
                    len = i;
                }
            }
        }
        //System.out.println(start + " = " + len);
        String res = s.substring(start, start + len);
        return res;
    }

    public String longestPalindrom(String s){
        int lens = s.length();
        if (lens == 0 || lens == 1) return s;
        StringBuilder sb = new StringBuilder();
        for(int i = lens - 1; i >= 0; i--){
            sb.append(s.charAt(i));
        }
        String s1 = sb.toString();
        String current = "";
        // 遍历较短的字符串，并依次减少短字符串的字符数量，判断长字符是否包含该子串
        for(int i=0; i<s.length(); i++){
            for(int begin=0, end=s.length()-i; end<=s.length(); begin++, end++){
                String cur = s.substring(begin, end);
                if(s1.contains(cur)){
                    if(checkPalindrom(cur)){
                        if(cur.length() > current.length()){
                            current = cur;
                        }
                    }
                    //return current;
                }
            }
        }
        return current;
    }

    public String longestPalindrome3(String s) {
        int lens = s.length();
        if (lens == 0 || lens == 1) return s;
        StringBuilder sb = new StringBuilder();
        for(int i = lens - 1; i >= 0; i--){
            sb.append(s.charAt(i));
        }
        String s1 = sb.toString();
        int max = 0;
        int start1 = 0;
        int start2 = 0;
        int len = 0;
        String res = "";
        while(start1 < lens && start2 < lens){
            System.out.println(start1 + " = " + start2);
            if(start2 == lens) {
                start2 = 0;
                start1++;
            }
            if(s.charAt(start1) == s1.charAt(start2)){
                int p = start1;
                while(p < lens && start2 < lens){
                    if(s.charAt(p) == s1.charAt(start2)){
                        len++;
                        p++;
                        start2++;
                    } else {
                        String tmp = s.substring(start1, start1 + len);
                        //System.out.println(tmp);
                        if(checkPalindrom(tmp)){
                            if(tmp.length() > max){
                                res = tmp;
                                max = tmp.length();
                            }
                        }
                        len = 0;
                        break;
                    }
                }
                System.out.println(start1 + ", " + len);
                // 可能全部匹配
                if(len > 0){
                    String tmp = s.substring(start1, start1 + len);
                    if(checkPalindrom(tmp)){
                        if(tmp.length() > max){
                            res = tmp;
                            max = tmp.length();
                        }
                    }
                    len = 0;
                }
            } else {
                start2++;
            }
        }
        return res;
    }

    public boolean checkPalindrom(String s){
        //System.out.println("s = " + s);
        int lens = s.length();
        int len = (lens - 1) / 2;
        for(int i = 0; i <= len; i++){
            if(s.charAt(i) != s.charAt(lens - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome2(String s) {
        int lens = s.length();
        if (lens == 0 || lens == 1) return s;
        int[][] arr = new int[lens][lens];
        String res = "";
        for (int i = 0; i < lens; i++) {
            arr[i][i] = 1;
            res = chackMaxStr(s, res, arr, i, i);
            res = getLongStr(s, res, arr, i - 1, i + 1, lens);
            //System.out.println(res);
            if((i + 1) < lens) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    arr[i][i + 1] = 2;
                    // 需要特殊处理
                    res = chackMaxStr(s, res, arr, i, i + 1);
                    res = getLongStr(s, res, arr, i - 1, i + 2, lens);
                } else {
                    arr[i][i + 1] = 1;
                    // 需要特殊处理
                    res = chackMaxStr(s, res, arr, i, i + 1);
                    res = getLongStr(s, res, arr, i, i + 2, lens);
                }
                //System.out.println(res);
            }
        }
        printArr(arr);
        return res;
    }

    public String chackMaxStr(String s, String cur, int[][] arr, int i, int j){
        String res = cur;
        int max = cur.length();
        if(arr[i][j] > max){
            res = s.substring(i, j + 1);
        }
        return res;
    }

    public String getLongStr(String s, String cur, int[][] arr, int i, int j, int lens){
        String res = cur;
        int max = res.length();
        while(i >= 0 && j < lens){
            if(s.charAt(i) == s.charAt(j)){
                arr[i][j] = arr[i + 1][j - 1] + 2;
                if(arr[i][j] > max){
                    //System.out.println(i + " = " + j + ", " + s.substring(i, j + 1));
                    res = s.substring(i, j + 1);
                    max = arr[i][j];
                }
            } else {
                break;
            }
            i--;
            j++;
        }
        return res;
    }

    public void printArr(int[][] arr){
        int lens = arr.length;
        for(int i = 0; i < lens; i++){
            for(int j = 0; j < lens; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public String longestPalindrome1(String s) {
        int lens = s.length();
        if(lens == 0 || lens == 1) return s;
        int[][] arr = new int[lens][lens];
        int max = 0;
        String res = "";
        for(int i = 0; i < lens; i++){
            arr[i][i] = 1;
            max = Math.max(max, arr[i][i]);
            if(arr[i][i] >= max){
                res = s.substring(i, i + 1);
                //System.out.println("(" + i + "," + (i + 1) + ") = " + res);
            }
            //initArr(s, arr, i - 1, i + 1, lens);
            int p = i - 1;
            int q = i + 1;
            while(p >= 0 && q < lens){
                if(s.charAt(p) == s.charAt(q)){
                    arr[p][q] = arr[p + 1][q - 1] + 2;
                    max = Math.max(max, arr[p][q]);
                    if(arr[p][q] >= max){
                        res = s.substring(p, q + 1);
                        //System.out.println("(" + p + "," + (q + 1) + ") = " + res);
                    }
                } else {
                    break;
                    //arr[p][q] = arr[p + 1][q - 1];
                }
                p--;
                q++;
            }
            if((i + 1) < lens){
                if(s.charAt(i) == s.charAt(i + 1)){
                    arr[i][i + 1] = 2;
                    p = i - 1;
                    q = i + 2;
                    max = Math.max(max, arr[i][i + 1]);
                    if(arr[i][i + 1] >= max){
                        res = s.substring(i, i + 2);
                        //System.out.println("(" + p + "," + (q + 1) + ") = " + res);
                    }
                } else {
                    arr[i][i + 1] = 1;
                    p = i;
                    q = i + 2;
                }
                // initArr(s, arr, i - 1, i + 2, lens);
                while(p >= 0 && q < lens){
                    if(s.charAt(p) == s.charAt(q)){
                        arr[p][q] = arr[p + 1][q - 1] + 2;
                        max = Math.max(max, arr[p][q]);
                        if(arr[p][q] >= max){
                            res = s.substring(p, q + 1);
                            //System.out.println("(" + p + "," + (q + 1) + ") = " + res);
                        }
                    } else {
                        break;
                        //arr[p][q] = arr[p + 1][q - 1];
                    }
                    p--;
                    q++;
                }
            }
        }
        System.out.println("max = " + max);
        for(int i = 0; i < lens; i++){
            for(int j = 0; j < lens; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        return res;
    }

    public void initArr(String s, int[][] arr, int i, int j, int lens){
        while(i >= 0 && j < lens){
            if(s.charAt(i) == s.charAt(j)){
                arr[i][j] = arr[i + 1][j - 1] + 2;
            } else {
                arr[i][j] = arr[i + 1][j - 1];
            }
            i--;
            j++;
        }
    }
}
