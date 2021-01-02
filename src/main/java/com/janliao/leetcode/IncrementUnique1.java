package com.janliao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IncrementUnique1 {
    public static void main(String[] args) {
        int[] arr = {1,3,3,2,5,6,2,1};
        int res = new IncrementUnique1().minIncrementForUnique(arr);
        System.out.println(res);
    }

    public int minIncrementForUnique(int[] arr) {
        int lens = arr.length;
        if (lens == 0 || lens == 1) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i : arr) {
            if(map.containsKey(i)){
                int j = i;
                while(true){
                    if(map.containsKey(++j)){
                        sum++;
                    } else {
                        map.put(j, 1);
                        sum++;
                        break;
                    }
                }
            } else {
                map.put(i, 1);
            }
        }
        return sum;
    }

}
