package com.janliao.leetcode;

import java.util.*;
public class Main1{
    private static final double P = 3.1415926535897932;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int h = in.nextInt();
        if(r < 0 || h < 0){
            System.out.println("0.00 0.00");
        } else{
            double v = P * r * r * h;
            double s = 2 * P * r * h + 2 * P * r * r;
            //System.out.println(v + " " + s);
            double a = (v * 100);
            double b = (s * 100);
            v = (double)Math.round(a)/100;
            s = (double)Math.round(b)/100;
            System.out.println(v + " " + s);
        }
    }
}
