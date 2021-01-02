package com.janliao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        List<List<Integer>> list = new Subsets().subsets(nums);
        for(List<Integer> li : list){
            for(int i : li){
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        if(nums.length == 0){
            list.add(li);
            return list;
        }
        for(int i : nums){
            List<List<Integer>> ll = new ArrayList<>();
            for(List<Integer> tmp : list){
                List<Integer> tp = new ArrayList<>(tmp);
                ll.add(tp);
            }
            for(List<Integer> tmp : list){
                tmp.add(i);
                ll.add(tmp);
            }
            List<Integer> ls = new ArrayList<>();
            ls.add(i);
            //list.add(ls);
            list = ll;
            list.add(ls);
        }
        list.add(li);
        return list;
    }
}
