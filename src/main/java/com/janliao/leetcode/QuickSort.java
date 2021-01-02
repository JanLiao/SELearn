package com.janliao.leetcode;

public class QuickSort {
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

    public static void main(String[] args) {
        int[] arr = {-1, 4, -9, 0, 5, 4, 9, -2};
        new QuickSort().sortNums(arr, 0, arr.length - 1);
        for(int i : arr){
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
