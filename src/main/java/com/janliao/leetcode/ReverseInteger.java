package com.janliao.leetcode;

public class ReverseInteger {
    public static void main(String[] args) {
        int sum = 1;
        for(int i = 0; i < 30; i++){
            sum *= 2;
        }
        System.out.println(sum * 2 - 1);
        int res = new ReverseInteger().reverse1(563847412);
        String s = "2147483647";
        System.out.println(new StringBuilder(s).reverse());
        System.out.println(res);
    }

    public int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public int reverse(int x) {
        int sum = 0;
        int n = x;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        while(x != 0){
            int offset = x % 10;
            x = x / 10;
            if(sum > max / 10 || (sum == max / 10 && x > 7)){
                return 0;
            } else if(sum < min / 10 || (sum == min / 10 && x < -8)){
                return 0;
            }
            sum = 10 * sum + offset;
        }
        return sum;
    }
}
