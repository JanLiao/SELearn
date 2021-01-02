package com.janliao.leetcode;

public class SortedSubarray2 {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10,9,15};
        arr = new int[]{1, 2, 3, 4};
        //arr = new int[]{4,3,2,1};
        int res = new SortedSubarray2().findUnsortedSubarray(arr);
        System.out.println(res);
    }

    public int findUnsortedSubarray(int[] nums) {
        int lens = nums.length;
        if (lens == 0 || lens == 1) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for(int i = 1; i < lens; i++){
            if(nums[i] < nums[i - 1]){
                flag = true;
            }
            if(flag) min = Math.min(min, nums[i]);
        }
        flag = false;
        for(int i = lens - 2; i >= 0; i--){
            if(nums[i] > nums[i + 1]){
                flag = true;
            }
            if(flag) max = Math.max(max, nums[i]);
        }
        //System.out.println("min = " + min + ", max = " + max);
        int left = 0, right = lens - 1;
        for(left = 0; left < lens; left++){
            if(nums[left] > min){
                break;
            }
        }
        for(right = lens - 1; right >= 0; right--){
            if(nums[right] < max){
                break;
            }
        }
        return (right - left) > 0 ? (right - left + 1) : 0;
    }
}
