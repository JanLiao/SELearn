package com.janliao.leetcode;

import java.util.Arrays;

public class SortedSubarray {
    public static void main(String[] args) {
        int[] arr = {2,6,4,8,10,9,15};
        int res = new SortedSubarray().findUnsortedSubarray(arr);
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
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int left = 0;
        int right = lens - 1;
        for(int i = 0; i < lens; i++){
            if(nums[i] == snums[i]){
                left = i + 1;
            } else {
                break;
            }
        }
        for(int i = lens - 1; i >= 0; i--){
            if(nums[i] == snums[i]){
                right = i - 1;
            } else {
                break;
            }
        }
        return right - left + 1;
    }

}
