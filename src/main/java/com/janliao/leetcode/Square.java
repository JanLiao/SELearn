package com.janliao.leetcode;

public class Square {
    public static void main(String[] args) {
        int data = 16;
        int res = new Square().squa(data);
        System.out.println(res);
    }

    public int squa(int n){
        if(n == 0 || n == 1) return n;
        int l = 0;
        int r = n;
        while(l < r){
            int mid = (l + r) / 2;
            if(mid * mid == n){
                return mid;
            } else if(mid * mid > n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
            //System.out.println(l + ", " + r);
        }
        return l;
    }
}
