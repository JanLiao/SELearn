package com.janliao.leetcode;

public class SellStock {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int res = new SellStock().maxProfit(arr);
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
        int lens = prices.length;
        if(lens == 0 || lens == 1) return 0;
        int[] premax = new int[lens];
        int max = prices[lens - 1];
        for(int i = lens - 1; i >= 0; i--){
            if(prices[i] >= max){
                max = prices[i];
            }
            premax[i] = max;
        }
        int res = premax[0] - prices[0];
        for(int i = 1; i < lens; i++){
            int offset = premax[i] - prices[i];
            if(offset > res){
                res = offset;
            }
        }
        return res > 0 ? res : 0;
    }
}
