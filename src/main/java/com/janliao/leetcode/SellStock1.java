package com.janliao.leetcode;

public class SellStock1 {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int res = new SellStock1().maxProfit(arr);
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
        int lens = prices.length;
        if(lens == 0 || lens == 1) return 0;
        int max = prices[lens - 1];
        int offset = 0;
        for(int i = lens - 2; i >= 0; i--){
            if(max - prices[i] > offset){
                offset = max - prices[i];
            }
            if(prices[i] > max){
                max = prices[i];
            } else{
                continue;
            }
        }
        return offset;
    }
}
