package com.janliao.leetcode;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int res = new MaximumSubarray().maxSubArray(arr);
        System.out.println(res);
    }

    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int lens = nums.length;
        int[] dp = new int[lens];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < lens; i++){
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int lens = nums.length;
        int max = nums[0];
        int local = nums[0];
        for(int i = 1; i < lens; i++){
            local = Math.max(local + nums[i], nums[i]);
            max = Math.max(local, max);
        }
        return max;
    }
}
