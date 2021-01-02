package com.janliao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix1 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30}};
        arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> list = new SpiralMatrix1().spiralOrder(arr);
        for(int i : list){
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int len1 = matrix.length;
        if (len1 == 0) return list;
        int len2 = matrix[0].length;
        int i = 0;
        int j = -1;
        //list.add(matrix[i][j]);
        int l1 = len2;
        int l2 = len1 - 1;
        int l3 = len2 - 1;
        int l4 = len1 - 2;
        while(l1 > 0 && l2 > 0 && l3 > 0 && l4 > 0){
            for(int k = 0; k < l1; k++){
                list.add(matrix[i][j + k + 1]);
            }
            j = j + l1;
            l1 = l1 - 2;
            for(int k = 0; k < l2; k++){
                list.add(matrix[i + k + 1][j]);
            }
            i = i + l2;
            l2 = l2 - 2;
            for(int k = 0; k < l3; k++){
                list.add(matrix[i][j - k - 1]);
            }
            j = j - l3;
            l3 = l3 - 2;
            for(int k = 0; k < l4; k++){
                list.add(matrix[i - k - 1][j]);
            }
            System.out.println();
            i = i - l4;
            l4 = l4 - 2;
        }
        if(list.size() < len1 * len2){
            if(l1 > 0){
                for(int k = 0; k < l1; k++){
                    list.add(matrix[i][j + k + 1]);
                }
                j = j + l1;
                if(l2 > 0){
                    for(int k = 0; k < l2; k++){
                        list.add(matrix[i + k + 1][j]);
                    }
                    i = i + l2;
                    if(l3 > 0){
                        for(int k = 0; k < l3; k++){
                            list.add(matrix[i][j - k - 1]);
                        }
                        j = j - l3;
                    }
                }
            }
        }
        return list;
    }
}
