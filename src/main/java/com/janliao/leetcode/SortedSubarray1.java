package com.janliao.leetcode;

import java.util.Stack;

public class SortedSubarray1 {
    public static void main(String[] args) {
        int[] arr = {2,6,4,8,10,9,15};
        //arr = new int[]{1, 2, 3, 4};
        //arr = new int[]{4,3,2,1};
        int res = new SortedSubarray1().findUnsortedSubarray(arr);
        System.out.println(res);
    }

    public int findUnsortedSubarray(int[] nums) {
        int lens = nums.length;
        if (lens == 0 || lens == 1) return 0;
        int left = lens;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < lens; i++){
            while(!stack.isEmpty()){
                int tp = stack.peek();
                if(nums[i] < nums[tp]){
                    left = Math.min(left, stack.pop());
                } else {
                    break;
                }
            }
            stack.push(i);
            //left = i;
        }
        stack.clear();
        int right = 0;
        for(int i = lens - 1; i >= 0; i--){
            while(!stack.isEmpty()){
                int tp = stack.peek();
                if(nums[i] > nums[tp]){
                    right = Math.max(right, stack.pop());
                } else {
                    break;
                }
            }
            stack.push(i);
            //right = i;
        }
        //System.out.println("left = " + left + ", right = " + right);
        return (right - left) > 0 ? (right - left + 1) : 0;
    }
}
