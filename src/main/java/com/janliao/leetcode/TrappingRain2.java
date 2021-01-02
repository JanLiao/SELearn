package com.janliao.leetcode;

public class TrappingRain2 {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int a = new TrappingRain2().trap(arr);
        System.out.println(a);
    }

    public int trap(int[] height) {
        int lens = height.length;
        if (lens == 0 || lens == 1 || lens == 2) return 0;
        int container = 0;
        int max = 0;
        int sum = 0;
        for(int i = 0; i < lens; i++){
            sum += height[i];
            if(height[i] > max) max = height[i];
        }
        if(max == 0) return 0;
        int[][] left = new int[lens][max];
        int[][] right = new int[lens][max];
        int leftIdx = 0;
        int leftMax = height[0];
        for(int i = 0; i < lens; i++){
            if(height[i] > leftMax){
                leftMax = height[i];
                leftIdx = i;
                fillArr(0, i, height[i], left);
            } else{
                fillArr(leftIdx, i, height[i], left);
            }
        }
        int rightIdx = lens - 1;
        int rightMax = height[rightIdx];
        for(int i = lens - 1; i >= 0; i--){
            if(height[i] > rightMax){
                rightIdx = i;
                rightMax = height[i];
                fillArr(i, lens - 1, height[i], right);
            } else{
                fillArr(i, rightIdx, height[i], right);
            }
        }
        for(int i = 0; i < lens; i++){
            for(int j = 0; j < max; j++){
                if(left[i][j] > 0 && right[i][j] > 0){
                    container += 1;
                }
            }
        }
        return container - sum;
    }

    private void fillArr(int left, int right, int h, int[][] arr) {
        for(int i = left; i <= right; i++){
            for(int j = 0; j < h; j++){
                arr[i][j] += 1;
            }
        }
    }
}
