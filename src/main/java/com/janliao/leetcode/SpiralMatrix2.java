package com.janliao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix2 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30}};
        arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> list = new SpiralMatrix2().spiralOrder(arr);
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
        int[] r = {0, 1, 0, -1};
        int[] w = {1, 0, -1, 0};
        int id = 0;
        for(int k = 0, len = len1 * len2; k < len; k++){
            //System.out.println(i + ", " + j);
            list.add(matrix[i][j]);
            arr[i][j] = 1;
            int a = i + r[id];
            int b = j + w[id];
            if((b >= 0) && (b < len2) && (a >= 0) && (a < len1) && (arr[a][b] == 0)){
                i = a;
                j = b;
            } else{
                id = (id + 1) % 4;
                i = i + r[id];
                j = j + w[id];
            }
        }
        return list;
    }
}
