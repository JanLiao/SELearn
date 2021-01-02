package com.janliao.leetcode;

public class SubarraySum {
    public static void main(String[] args) {
        int[] arr = {1,1};
        int a = new SubarraySum().minSubArrayLen(3, arr);
        System.out.println(a);
    }

    public int minSubArrayLen(int s, int[] nums) {
        int lens = nums.length;
        if(lens == 0) return 0;
        if(lens == 1){
            return s >= nums[0] ? 1 : 0;
        }
//        for(int i = 0; i < lens; i++){
//            if(nums[i] >= s) return 1;
//        }
        int l, min;
        l = 0;
        min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < lens; i++){
            sum += nums[i];
            while(sum >= s){
                int tp = (i - l + 1);
                if(tp < min) {
                    min = tp;
                }
                sum -= nums[l++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
