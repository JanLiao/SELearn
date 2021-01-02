package com.janliao.leetcode;

public class MaxHeap {
    public static void main(String[] args) {
        int[] arr = {2,1,10,5,3,2,6,9,11,13,0, 15};
        new MaxHeap().maxHeap(arr);
        for(int i : arr){
            System.out.print(i + "\t");
        }
        System.out.println();
    }
    public void maxHeap(int[] arr){
        int lens = arr.length;
        if(lens == 0 || lens == 1) return ;
        for(int i = arr.length - 1; i > 0; i--){
            heap(arr, i);
            // 最大元素位于堆顶,互换元素
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
        }
    }

    public void heap(int[] arr, int len){
        // 如果为奇数,只需要比较上下两元素,否则左右两元素与上层元素比较
        if((len & 1) == 1){
            if(arr[len] > arr[len / 2]){
                swap(arr, len / 2, len);
            }
            len--;
        }
        for(int i = len; i > 1; i = i - 2){
            int j = i - 1;
            int k = arr[i] > arr[j] ? i : j;
            if(arr[k] > arr[j / 2]){
                swap(arr, k, j / 2);
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
