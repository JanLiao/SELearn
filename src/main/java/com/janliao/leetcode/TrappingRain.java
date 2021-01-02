package com.janliao.leetcode;

import java.util.Stack;

public class TrappingRain {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int a = new TrappingRain().trap(arr);
        System.out.println(a);
    }

    public int trap(int[] height) {
        int lens = height.length;
        if(lens == 0 || lens == 1 || lens == 2) return 0;
        int[] premax = getMax(height);
        int[] sub = getFirstMax(height);
        int container = 0;
        int i = 0;
        while(i < lens - 1){
            int j = sub[i];
            if(j > 0){
                //int min = height[i] > height[j] ? height[j] : height[i];
                int min = Math.min(height[i], height[j]);
                container += min * (j - i) - min * 1;
                // 减掉之间的数据高度
                for(int t = i + 1; t < j; t++){
                    container -= height[t];
                }
                i = j;
            } else{
                int k = premax[i];
                //int min = height[i] > height[k] ? height[k] : height[i];
                int min = Math.min(height[i], height[k]);
                container += min * (k - i) - min * 1;
                for(int t = i + 1; t < k; t++){
                    container -= height[t];
                }
                i = k;
            }
            //System.out.println(container);
        }
        //System.out.println(container);
        return container;
    }

    private int[] getFirstMax(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for(int i = 0, len = arr.length; i < len; i++){
            if(stack.isEmpty()){
                stack.push(i);
                //res[i] = 0;
            } else{
                while(!stack.isEmpty()){
                    int num = arr[stack.peek()];
                    if(arr[i] > num){
                        res[stack.pop()] = i;
                    } else{
                        break;
                    }
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            res[stack.pop()] = 0;
        }
        return res;
    }

    private int[] getMax(int[] height) {
        int lens = height.length;
        int[] premax = new int[lens];
        int max = height[lens - 1];
        int idx = lens - 1;
        for(int i = lens - 1; i >= 0; i--){
            premax[i] = idx;
            if(height[i] >= max){
                idx = i;
                max = height[i];
            }
        }
        return premax;
    }
}
