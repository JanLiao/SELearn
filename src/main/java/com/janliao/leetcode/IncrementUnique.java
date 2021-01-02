package com.janliao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IncrementUnique {
    public static void main(String[] args) {
        int[] arr = {1,3,3,2,5,6,2,1};
        int res = new IncrementUnique().minIncrementForUnique(arr);
        System.out.println(res);
    }

    public int minIncrementForUnique(int[] arr) {
        int lens = arr.length;
        if(lens == 0 || lens == 1) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            if(map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int sum = 0;
        for(int i : arr){
            if(map.get(i) == 1){
                continue;
            } else {
                while(map.get(i) != 1){
                    int j = i;
                    int v = map.get(i);
                    while(true){
                        if(map.containsKey(++j)){
                            sum++;
                            continue;
                        } else {
                            sum++;
                            map.put(j, 1);
                            map.put(i, v - 1);
                            break;
                        }
                    }
                }
            }
        }
        return sum;
    }
}
