package com.janliao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        int k = 2;
        int[] res = new TopKFrequentElements().topKFrequent(arr, k);
        for(int i : res){
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public int[] topKFrequent(int[] arr, int k) {
        int[] res = new int[k];
        int lens = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < lens; i++){
            if(map.containsKey(arr[i])){
                int val = map.get(arr[i]);
                map.put(arr[i], val + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        int idx = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(idx < k){
                res[idx++] = entry.getKey();
            } else if(idx == k) {
                minHeap(res, k - 1, map);
                if(map.get(entry.getKey()) > map.get(res[0])){
                    // 替换并重新生成最小堆
                    res[0] = entry.getKey();
                    minHeap(res, k - 1, map);
                }
                idx++;
            } else {
                if(map.get(entry.getKey()) > map.get(res[0])){
                    // 替换并重新生成最小堆
                    res[0] = entry.getKey();
                    minHeap(res, k - 1, map);
                }
            }
        }
        return res;
    }

    public void minHeap(int[] arr, int lens, Map<Integer, Integer> map){
        if((lens & 1) == 1){
            if(map.get(arr[lens]) < map.get(arr[lens / 2])){
                swap(arr, lens, lens / 2);
            }
            lens--;
        }
        for(int i = lens; i > 1; i = i - 2){
            int j = i - 1;
            int k = map.get(arr[i]) > map.get(arr[j]) ? j : i;
            if(map.get(arr[k]) < map.get(arr[j / 2])){
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
