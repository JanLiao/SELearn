package com.janliao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> list = new SpiralMatrix().spiralOrder(arr);
        for(int i : list){
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int len1 = matrix.length;
        if(len1 == 0) return list;
        int len2 = matrix[0].length;
        int[][] arr = new int[len1][len2];
        int i = 0;
        int j = 0;
        list.add(matrix[i][j]);
        arr[i][j] = 1;
        while(true){
            //System.out.println(i + ", " + j);
            //printArr(arr);
            if(((j + 1) < len2) && (arr[i][j + 1] == 0)){
                while(((j + 1) < len2) && (arr[i][j + 1] == 0)){
                    list.add(matrix[i][j + 1]);
                    arr[i][j + 1] = 1;
                    j++;
                }
            } else if((i + 1) < len1 && (arr[i + 1][j] == 0)){
                while((i + 1) < len1 && (arr[i + 1][j] == 0)){
                    list.add(matrix[i + 1][j]);
                    arr[i + 1][j] = 1;
                    i++;
                }
            } else if((j - 1) >= 0 && (arr[i][j - 1] == 0)){
                while((j - 1) >= 0 && (arr[i][j - 1] == 0)){
                    list.add(matrix[i][j - 1]);
                    arr[i][j - 1] = 1;
                    j--;
                }
            } else if((i - 1) >= 0 && (arr[i - 1][j] == 0)){
                while((i - 1) >= 0 && (arr[i - 1][j] == 0)){
                    list.add(matrix[i - 1][j]);
                    arr[i - 1][j] = 1;
                    i--;
                }
            } else{
                break;
            }
        }
        return list;
    }

    private void printArr(int[][] arr) {
        int len1 = arr.length;
        int len2 = arr[0].length;
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
