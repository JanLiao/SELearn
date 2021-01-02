package com.janliao.leetcode;

public class TrappingRain4 {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int a = new TrappingRain4().trap(arr);
        System.out.println(a);
    }

    public int trap(int[] height) {
        int lens = height.length;
        if (lens == 0 || lens == 1 || lens == 2) return 0;
        int container = 0;
        int left, right;
        left = 0;
        right = lens - 1;
        int min = Math.min(height[left], height[right]);
        int idx = height[left] > height[right] ? right : left;
        while(left != right){
            if(height[idx] < min){
                container += (min - height[idx]);
            }
            int mintmp = Math.min(height[left], height[right]);
            if(mintmp > min) min = mintmp;
            //System.out.println(left + " = " + right + " = " + min);
            if(height[left] > height[right]){
                idx = --right;
            } else{
                idx = ++left;
            }
        }
        return container;
    }
}
