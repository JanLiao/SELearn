package com.janliao.leetcode;

import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3},{15,18},{3,9},{2,6},{8,10}};
        int[][] res = new MergeIntervals().merge(arr);
        for(int i = 0; i < res.length; i++){
            System.out.println(res[i][0] + "\t" + res[i][1]);
        }
    }

    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0 || intervals.length == 1) return intervals;
        // 先进行快排,再进行一次遍历
        quickSort(intervals, 0, intervals.length - 1);
//        for(int i = 0; i < intervals.length; i++){
//            System.out.println(intervals[i][0] + "\t" + intervals[i][1]);
//        }
        List<List<Integer>> list = new ArrayList<>();
        int p = intervals[0][0];
        int q = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int t1 = intervals[i][0];
            int t2 = intervals[i][1];
            if(t1 > q){
                List<Integer> lst = new ArrayList<>();
                lst.add(p);
                lst.add(q);
                list.add(lst);
                p = t1;
                q = t2;
            } else{
                q = t2 > q ? t2 : q;
            }
        }
        List<Integer> lst = new ArrayList<>();
        lst.add(p);
        lst.add(q);
        list.add(lst);
        int[][] ints = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            ints[i][0] = list.get(i).get(0);
            ints[i][1] = list.get(i).get(1);
        }
        return ints;
    }

    public void quickSort(int[][] intervals, int left, int right){
        if(left > right) return;
        int i = left;
        int j = right;
        int tmp = intervals[i][0];
        int tmp1 = intervals[i][1];
        while(i != j){
            while(i < j && intervals[j][0] >= tmp) j--;
            while(i < j && intervals[i][0] <= tmp) i++;
            if(i < j){
                int tp = intervals[i][0];
                int tp1 = intervals[i][1];
                intervals[i][0] = intervals[j][0];
                intervals[i][1] = intervals[j][1];
                intervals[j][0] = tp;
                intervals[j][1] = tp1;
            }
        }
        intervals[left][0] = intervals[j][0];
        intervals[left][1] = intervals[j][1];
        intervals[j][0] = tmp;
        intervals[j][1] = tmp1;
        quickSort(intervals, left, i - 1);
        quickSort(intervals, i + 1, right);
    }
}
