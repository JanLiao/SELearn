package com.janliao.leetcode;

public class TrappingRain3 {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int a = new TrappingRain3().trap(arr);
        System.out.println(a);
    }

    public int trap(int[] height){
        int lens = height.length;
        if (lens == 0 || lens == 1 || lens == 2) return 0;
        int[] left = new int[lens];
        int[] right = new int[lens];
        int container = 0;
        int leftMmax = height[0];
        int rightMax = height[lens - 1];
        left[0] = height[0];
        for(int i = 1; i < lens; i++){
            if(height[i] > leftMmax){
                leftMmax = height[i];
            }
            left[i] = leftMmax;
        }
        right[lens - 1] = height[lens -1];
        for(int j = lens - 2; j >= 0; j--){
            if(height[j] > rightMax){
                rightMax = height[j];
            }
            right[j] = rightMax;
        }
        for(int i = 0; i < lens; i++){
            int min = Math.min(left[i], right[i]);
            container += (min - height[i]);
        }
        return container;
    }
}
