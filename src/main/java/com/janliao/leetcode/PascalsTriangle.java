package com.janliao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> res = new PascalsTriangle().generate(n);
        for(List<Integer> list : res){
            for(int i : list){
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows == 0) return list;
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        list.add(l1);
        if(numRows == 1) return list;
        List<Integer> l2 = new ArrayList<>();
        l2.add(1); l2.add(1);
        list.add(l2);
        if(numRows == 2) return list;
        int[] arr = new int[numRows];
        arr[0] = 1; arr[1] = 1;
        for(int i = 3; i <= numRows; i++){
            List<Integer> l = new ArrayList<>();
            l.add(1);
            int[] arr1 = new int[numRows];
            arr1[0] = 1;
            for(int j = 1; j < i - 1; j++){
                int tmp = arr[j - 1] + arr[j];
                //System.out.println(j + ", " + tmp);
                arr1[j] = tmp;
                l.add(tmp);
            }
            arr1[i - 1] = 1;
            arr = arr1;
            l.add(1);
            list.add(l);
        }
        return list;
    }
}
