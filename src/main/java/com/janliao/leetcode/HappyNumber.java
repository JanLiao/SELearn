package com.janliao.leetcode;

public class HappyNumber {
    public static void main(String[] args) {
        boolean flag = new HappyNumber().isHappy(20);
        System.out.println(flag);
    }

    public boolean isHappy(int n) {
        if(n == 1) return true;
        if(n == 0) return false;
        int sum = n;
        boolean flag = false;
        while(true){
            sum = remaind(sum);
            System.out.println(sum);
            if(sum == 1){
                return true;
            } else if(sum == 89){
                break;
            }
        }
        return flag;
    }

    public int remaind(int n){
        int sum = 0;
        while(n > 0){
            int offset = n % 10;
            sum += offset * offset;
            n = n / 10;
        }
        return sum;
    }
}
