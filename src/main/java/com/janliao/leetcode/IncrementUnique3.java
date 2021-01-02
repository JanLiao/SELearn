package com.janliao.leetcode;

public class IncrementUnique3 {
    public static void main(String[] args) {
        int[] arr = {1,3,3,2,5,6,2,1};
        int res = new IncrementUnique3().minIncrementForUnique(arr);
        System.out.println(res);
    }

    public void quickSort(int[] arr, int left, int right){
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

    public int minIncrementForUnique(int[] arr) {
        int lens = arr.length;
        if (lens == 0 || lens == 1) return 0;
        int sum = 0;
        quickSort(arr, 0, arr.length - 1);
        for(int i : arr){
            System.out.print(i + "\t");
        }
        System.out.println();
        int cp = arr[0];
        for(int i = 1; i < lens; i++){
            int value = arr[i];
            //System.out.println("cp = " + cp);
            if(arr[i] != arr[i - 1]){
                if(cp >= value){
                    cp++;
                    sum += (cp - value);
                } else {
                    cp = value;
                }
            } else {
                cp++;
                sum += (cp - value);
            }
        }
        return sum;
    }
}
