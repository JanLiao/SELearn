package com.janliao.leetcode;

public class IncrementUnique2 {
    public static void main(String[] args) {
        int[] arr = {1,3,3,2,5,6,2,1};
        int res = new IncrementUnique2().minIncrementForUnique(arr);
        System.out.println(res);
    }
    private static final int len = 80000;

    public int minIncrementForUnique(int[] arr) {
        int lens = arr.length;
        if (lens == 0 || lens == 1) return 0;
        int sum = 0;
        int[] res = new int[len];
        for(int i : arr){
            if(res[i] == 1){
                int j = i;
                while(true){
                    if(res[++j] == 1){
                        sum++;
                    } else {
                        sum++;
                        res[j] = 1;
                        break;
                    }
                }
            } else {
                res[i] = 1;
            }
        }
        return sum;
    }
}
