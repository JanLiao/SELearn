package com.janliao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets1 {
    public static void main(String[] args) {
        //System.out.println((1 << 0) + " = " + (1 << 1));
        System.out.println(3 & (1 << 1));
        System.out.println(3 & (1 << 0));
        List<int[]> list1 = new ArrayList<>();
        int[] nums = {1, 2, 3, 4, 5, 6};
        List<List<Integer>> list = new Subsets1().subsets(nums);
        for(List<Integer> li : list){
            for(int i : li){
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int lens = nums.length;
        if(lens == 0){
            List<Integer> ls = new ArrayList<>();
            list.add(ls);
            return list;
        }
        int nm = (int)Math.pow(2, lens);
        for(int i = 0; i < nm; i++){
            List<Integer> ls = getChildSet(i, lens, nums);
            list.add(ls);
        }
        return list;
    }

    private List<Integer> getChildSet(int n, int lens, int[] nums) {
        List<Integer> list = new ArrayList<>();
        //System.out.println("n = " + n);
        for(int i = 0; i < lens; i++){
            int t = (n & (1 << i));
            if(t >= 1){
                list.add(nums[i]);
            }
        }
        //System.out.println(list.size());
        return list;
    }
}
