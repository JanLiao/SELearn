package com.janliao.leetcode;

public class SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        sortNums(nums, 0, nums.length - 1);
        int closest = 0;
        int abs = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        for(int i = 0, lens = nums.length - 2; i < lens; i++){
            left = i + 1;
            right = nums.length - 1;
            while(left < right){
                int sum = nums[left] + nums[right];
                int offset = target - nums[i];
                int tmp = (offset - sum) > 0 ? (offset - sum) : (sum - offset);
                if(tmp < abs){
                    abs = tmp;
                    closest = sum + nums[i];
                }
                if((offset - sum) > 0){
                    left++;
                } else if((offset - sum) == 0){
                    break;
                } else{
                    right--;
                }
            }
        }
        return closest;
    }

    public void sortNums(int[] nums, int left, int right){
        if(left > right) return;
        int i = left;
        int j = right;
        int tmp = nums[i];
        while(i != j){
            while(i < j && nums[j] >= tmp) j--;
            while(i < j && nums[i] <= tmp) i++;
            if(i < j){
                int tp = nums[i];
                nums[i] = nums[j];
                nums[j] = tp;
            }
        }
        nums[left] = nums[i];
        nums[i] = tmp;
        sortNums(nums, left, i - 1);
        sortNums(nums, i + 1, right);
    }
}