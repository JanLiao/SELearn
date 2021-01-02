package com.janliao.compare;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 0, 10, 8, 2, 11};
        new QuickSort().quickSort(arr, 0, arr.length - 1);
        for(int i : arr){
            System.out.print(i + "\t");
        }
        System.out.println();
        for(int i = 3; i > 3; i++){
            System.out.println("---");
            System.out.println(i);
        }
    }

    private void quickSort(int[] arr, int left, int right) {
        if(left > right) return ;
        int i = left;
        int j = right;
        int tmp = arr[left];
        while(i != j){
            while(i < j && arr[j] >= tmp) j--;
            while(i < j && arr[i] <= tmp) i++;
            if(i < j){
                int tp = arr[i];
                arr[i] = arr[j];
                arr[j] = tp;
            }
        }
        arr[left] = arr[j];
        arr[j] = tmp;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }
}
