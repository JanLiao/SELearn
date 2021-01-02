package com.janliao.leetcode;

public class HappyNumber1 {
    public static void main(String[] args) {
        boolean flag = new HappyNumber1().isHappy(19);
        System.out.println(flag);
    }

    public boolean isHappy(int n){
        if(n == 1) return true;
        if(n == 0) return false;
        int fast = remaind(remaind(n));
        int slow = remaind(n);
        while(fast != slow){
            fast = remaind(remaind(fast));
            slow = remaind(slow);
        }
        return slow == 1;
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
