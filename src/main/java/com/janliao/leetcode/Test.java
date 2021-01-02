package com.janliao.leetcode;

import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        int[] res = process(arr);
        for(int i : res){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] process(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for(int i = 0, len = arr.length; i < len; i++){
            if(stack.isEmpty()){
                stack.push(i);
                //res[i] = 0;
            } else{
                while(!stack.isEmpty()){
                    int num = arr[stack.peek()];
                    if(arr[i] > num){
                        res[stack.pop()] = i;
                    } else{
                        break;
                    }
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            res[stack.pop()] = 0;
        }
        return res;
    }
}
