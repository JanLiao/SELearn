package com.janliao.compare;

import java.util.Scanner;

public class MainX {
    public static void process(int n){
        // 还有本身
        if(checkSelf(n)){
            System.out.println(n);
            return ;
        }
        // 判断n前面的对称数
        int pre = n;
        while(true){
            int[] arr = getBit(--pre);
            if(check(arr)){
                //System.out.println(pre);
                break;
            }
        }

        // 判断n后面的对称数
        int next = n;
        while(true){
            if(next == Integer.MAX_VALUE){
                break;
            }
            int[] arr = getBit(++next);
            if(check(arr)){
                //System.out.println(next);
                break;
            }
        }
        if(next == Integer.MAX_VALUE){
            System.out.println(pre);
            return ;
        }
        if((n - pre) == (next - n)){
            System.out.println(pre + "," + next);
            //System.out.println(next);
        } else if((n - pre) < (next - n)) {
            System.out.println(pre);
        } else {
            System.out.println(next);
        }
    }

    public static boolean checkSelf(int n){
        int[] arr = getBit(n);
        if(check(arr)){
            return true;
        }
        return false;
    }

    public static boolean check(int[] arr){
        int lens = arr.length;
        int len = (lens - 1) / 2;
        for(int i = 0; i <= len; i++){
            if(arr[i] != arr[lens - 1 - i]){
                return false;
            }
        }
        return true;
    }

    public static int[] getBit(int n){
        int sum = 0;
        int tmp = n;
        while(tmp > 0){
            sum++;
            tmp = tmp / 10;
        }
        int[] arr = new int[sum];
        tmp = n;
        while(tmp > 0){
            arr[--sum] = tmp % 10;
            tmp = tmp / 10;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n <= 0) {
            System.out.println("ERROR");
        } else {
            process(n);
        }
    }
}
