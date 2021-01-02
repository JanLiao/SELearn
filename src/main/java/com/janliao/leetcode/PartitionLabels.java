package com.janliao.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        //s = "abcdefgahig";
        List<Integer> list = new PartitionLabels().partitionLabels(s);
        for(int i : list) {
            System.out.println(i);
        }
    }

    public List<Integer> partitionLabels(String s){
        List<Integer> list = new ArrayList<>();
        if("".equals(s)) {
            list.add(0);
            return list;
        }
        if(s.length() == 1) {
            list.add(1);
            return list;
        }
        int[] arr = new int[26];
        int lens = s.length();
        for(int i = 0; i < lens; i++){
            arr[s.charAt(i) - 'a'] = i;
        }
        int j = 0;
        int idx = -1;
        for(int i = 0; i < lens; i++){
            j = Math.max(j, arr[s.charAt(i) - 'a']);
            if(i == j){
                list.add(i - idx);
                idx = i;
            }
        }
        return list;
    }

    public List<Integer> partitionLabels2(String s) {
        List<Integer> list = new ArrayList<>();
        if("".equals(s)) {
            list.add(0);
            return list;
        }
        if(s.length() == 1) {
            list.add(1);
            return list;
        }
        int start = 0;
        int end = 1;
        int idx = end;
        while(start < s.length()){
            //System.out.println(start + "," + end);
            String tmp = s.substring(start, end);
            while(idx < s.length()){
                System.out.println(tmp + " = " + idx + ", " + s.charAt(idx));
                if(tmp.contains("" + s.charAt(idx))){
                    end = ++idx;
                    break;
                } else{
                    idx++;
                }
            }
            System.out.println("idx = " + idx);
            if(idx == s.length()){
                list.add(end - start);
                start = end;
                end = end + 1;
                idx = end;
            }
        }
        return list;
    }

    public List<Integer> partitionLabels1(String s) {
        List<Integer> list = new ArrayList<>();
        if("".equals(s)) {
            list.add(0);
            return list;
        }
        if(s.length() == 1) {
            list.add(1);
            return list;
        }
        Set<Character> set = new HashSet<>();
        int lens = s.length();
        int idx = 0;
        set.add(s.charAt(idx));
        while(idx < lens){
            int id = checkStr(idx, s, set);
            set = new HashSet<>();
            list.add(s.substring(idx, id - idx).length());
            idx = id;
        }
        return list;
    }

    public int checkStr(int idx, String s, Set<Character> set){
        int id = idx;
        String tmp = s.substring(idx + 1);
        for(char c : set){
            if(tmp.contains("" + c)){
                int offset = tmp.indexOf(c);
                id = offset;
                for(int i = idx; i <= offset; i++){
                    set.add(tmp.charAt(i));
                }
                idx = offset;
            }
        }
        return id + 1;
    }
}
