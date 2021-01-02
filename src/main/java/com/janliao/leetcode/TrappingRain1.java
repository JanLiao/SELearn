package com.janliao.leetcode;

public class TrappingRain1 {
    public static void main(String[] args) {
        int[] arr = {4,3,3,9,3,0,9,2,8,3};
        int a = new TrappingRain1().trap(arr);
        System.out.println(a);
    }

    private int trap(int[] height) {
        int lens = height.length;
        if(lens == 0 || lens == 1 || lens == 2) return 0;
        int i, left, right, container;
        lens = height.length;
        i = left = right = container = 0;
        while(i < lens - 1){
            int[] lf = getLeft(right, i, height);
            if(lf[0] == -1){
                i++;
                continue;
            }
            left = lf[0];
            right = getRight(lf[1], i, height);
            System.out.println(i + " = "+ left + " = " + right);
            if(i != left && i != right){
                int min = Math.min(height[left], height[right]);
                container += min * (right - left) - min * 1;
                // 减掉之间的数据高度
                for(int t = left + 1; t < right; t++){
                    container -= height[t];
                }
                i = right;
            } else{
                i++;
            }
        }
        return container;
    }

    private int getRight(int smax, int i, int[] height) {
        if(i == height.length - 1) return i;
        int idx = i;
        int max = height[i];
        int midx = -1;
        for(int j = i + 1; j < height.length; j++){
            if(height[j] > max){
                idx = j;
                max = height[j];
            }
            if(midx == -1){
                if(height[j] >= smax){
                    midx = j;
                }
            }
        }
        //System.out.println(max +" = " + smax);
        return midx == -1 ? idx : midx;
    }

    private int[] getLeft(int left, int i, int[] height) {
        int[] amax = new int[2];
        amax[0] = -1;
        int max = height[i];
        for(int j = i - 1; j >= left; j--){
            if(height[j] > max){
                amax[0] = j;
                amax[1] = height[j];
                max = height[j];
            }
        }
        return amax;
    }
}
