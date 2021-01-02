package com.janliao.leetcode;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        int[] arr = {3,2,6,4,8,10,9,15,2};
        int res = new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(arr);
        System.out.println(res);
    }

    public int findUnsortedSubarray(int[] nums) {
        int lens = nums.length;
        if(lens == 0 || lens == 1) return 0;
        int offset = 0;
        // 牺牲O(n),先遍历一遍数组,判断数组是否已有序
        for(int i = 1; i < lens; i++){
            offset = nums[i] - nums[i - 1];
            if(offset >= 0){
                continue;
            } else {
                break;
            }
        }
        if(offset >= 0) return 0;
        // 向前遍历,求出左侧已序下标
        int left = 0;
        int min = 0;
        label1:
        for(int i = 0; i < lens; i++){
            min = nums[i];
            for(int j = i + 1; j < lens; j++){
                if(nums[j] >= min){
                    continue;
                } else {
                    left = i;
                    break label1;
                }
            }
        }
        //System.out.println("left = " + left);
        // 向后遍历,求出左侧已序下标
        int right = lens - 1;
        int max = 0;
        label2:
        for(int i = lens - 1; i >= 0; i--){
            max = nums[i];
            for(int j = i - 1; j >= 0; j--){
                if(nums[j] <= max){
                    continue;
                } else {
                    right = i;
                    break label2;
                }
            }
        }
        //System.out.println("right = " + right);
        return (right - left + 1);
    }
}
