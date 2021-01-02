package com.janliao.leetcode;

public class FFESortedArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,3,3,4,5,6,7,8};
        int[] res = new FFESortedArray().searchRange(arr, 8);
        System.out.println(res[0] + ", " + res[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int lens = nums.length;
        if(lens == 0) return new int[]{-1,-1};
        int left = 0;
        int right = lens - 1;
        int fidx = -1;
        int eidx = -1;
        // 先二分找出target下标
        int idx = binarySearch(nums, left, right, target);
        fidx = idx;
        eidx = idx;
        //System.out.println(fidx + ", " + eidx);
        if(fidx == -1) {
            return new int[]{-1,-1};
        }
        // 继续二分查找最小下标
        if(fidx > 0){
            while(true){
                left = 0;
                right = fidx - 1;
                int min = binarySearch(nums, left, right, target);
                //System.out.println("min = " + min);
                if(min != -1){
                    fidx = min;
                } else {
                    break;
                }
            }
        }
        //System.out.println("============");
        // 二分查找最大下标
        if(eidx < lens - 1){
            while(true){
                left = eidx + 1;
                right = lens - 1;
                int max = binarySearch(nums, left, right, target);
                //System.out.println("max = " + max);
                if(max == -1){
                    break;
                } else {
                    eidx = max;
                }
            }
        }
        return new int[]{fidx,eidx};
    }

    public int binarySearch(int[] nums, int left, int right, int target){
        int idx = -1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                idx = mid;
                break;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return idx;
    }
}
