package com.janliao.leetcode;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 0, 10, 8, 2, 11};
        int res = new KthLargestElement().findKthLargest(arr, 1);
        System.out.println(res);
    }

    public int findKthLargest(int[] nums, int k) {
        int lens = nums.length;
        int mid = lens / 2;
        // k小于mid时,使用最大堆找出第k大值
        if(mid > k){
            //System.out.println("最大堆");
            return maxHeap(nums, k);
        } else{// k大于mid时,使用最小堆找出第lens - k + 1小值
            //System.out.println("最小堆");
            return minHeap(nums, lens - k + 1);
        }
    }

    public int maxHeap(int[] arr, int k){
        int lens = arr.length;
        int res = 0;
        for(int i = lens - 1; i >= lens - k; i--){
            maHeap(arr, i);
            res = arr[0];
            arr[0] = arr[i];
            arr[i] = res;
        }
        return res;
    }

    public void maHeap(int[] arr, int lens){
        // 构建最大堆
        //int lens = arr.length - 1;
        // 如果奇数
        if((lens & 1) == 1){
            if(arr[lens] > arr[lens / 2]){
                swap(arr, lens, lens / 2);
            }
            lens--;
        }
        for(int i = lens; i > 1; i = i - 2){
            int k = arr[i] > arr[i - 1] ? i : (i - 1);
            if(arr[k] > arr[(i - 1) / 2]){
                swap(arr, k, (i - 1) / 2);
            }
        }
    }

    public int minHeap(int[] arr, int k){
        int lens = arr.length;
        int res = 0;
        for(int i = lens - 1; i >= lens - k; i--){
            miHeap(arr, i);
            res = arr[0];
            arr[0] = arr[i];
            arr[i] = res;
        }
        return res;
    }

    public void miHeap(int[] arr, int lens){
        // 最小堆
        if((lens & 1) == 1){
            if(arr[lens] < arr[lens / 2]){
                swap(arr, lens, lens / 2);
            }
            lens--;
        }
        for(int i = lens; i > 1; i = i - 2){
            int j = i - 1;
            int k = arr[i] < arr[j] ? i : j;
            if(arr[k] < arr[j / 2]){
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
