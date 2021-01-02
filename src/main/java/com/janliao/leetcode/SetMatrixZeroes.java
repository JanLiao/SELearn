package com.janliao.leetcode;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        //int[][] arr = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] arr = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        arr = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new SetMatrixZeroes().setZeroes(arr);
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        int len1 = matrix.length;
        if(len1 == 0) return ;
        int len2 = matrix[0].length;
        int[] r = new int[len1];
        int[] w = new int[len2];
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(matrix[i][j] == 0){
                    if(r[i] == 0){
                        //nulArr(matrix, i, len1, false);
                        r[i] = 1;
                    }
                    if(w[j] == 0){
                        //nulArr(matrix, j, len2, true);
                        w[j] = 1;
                    }
                }
            }
        }
        for(int i = 0; i < len1; i++){
            if(r[i] == 1){
                nulArr(matrix, i, len2, false);
            }
        }
        for(int i = 0; i < len2; i++){
            if(w[i] == 1){
                nulArr(matrix, i, len1, true);
            }
        }
    }

    private void nulArr(int[][] matrix, int k, int len, boolean flag){
        if(flag){
            for(int i = 0; i < len; i++){
                matrix[i][k] = 0;
            }
        } else{
            for(int i = 0; i < len; i++){
                matrix[k][i] = 0;
            }
        }
    }
}
