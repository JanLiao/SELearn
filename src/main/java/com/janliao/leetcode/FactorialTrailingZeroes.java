package com.janliao.leetcode;

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        int n = 2147483647;
        System.out.println(Integer.MAX_VALUE);
        int res = new FactorialTrailingZeroes().trailingZeroes1(n);
        System.out.println(res);
    }

    public int trailingZeroes(int n) {
        int count = 0;
        for (long i = 5; i <= n; i *= 5)
            count += n / i;
        return count;
    }

    public int trailingZeroes1(int n) {
        int num = n / 5;
        if(num == 0) return 0;
        int sum = 0;
        for(int i = 1; i <= num; i++){
            sum += nums(i * 5);
        }
        return sum;
    }

    private int nums(int n) {
        int sum = 0;
        while(n % 5 == 0){
            sum++;
            n = n / 5;
        }
        return sum;
    }
}
