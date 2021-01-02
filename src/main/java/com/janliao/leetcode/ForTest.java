package com.janliao.leetcode;

public class ForTest {
    public static void main(String[] args) {
        new Thread().getPriority();
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(j == 5){
                    break;
                } else{
                    System.out.println(i + ", " + j);
                }
            }
        }
    }
}
