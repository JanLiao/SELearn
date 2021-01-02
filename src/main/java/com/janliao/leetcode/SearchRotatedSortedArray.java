package com.janliao.leetcode;

public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {6,7,8,9,12,13,14,0,1,2,4,5};
        //arr = new int[]{6,7,0,1,2,4,5};
        //arr = new int[]{5,5,6,7,5,5,5,5,5,5,5};
        arr = new int[]{1,3};
        int res = new SearchRotatedSortedArray().search(arr, 3);
        System.out.println(res);
        arr = new int[]{4,5,6,7,8,9,0,1,2};
        arr = new int[]{4,5,0,1,2,3};
        int index = new SearchRotatedSortedArray().getArrayIndex(arr);
        System.out.println(index);
        //int idx = new SearchRotatedSortedArray().getArrayIndex(arr);
        //System.out.println(idx);
    }

    public int getArrayIndex(int[] nums){
        if(nums[nums.length - 1] > nums[0]) return 0;
        int left = 0;
        int right = nums.length - 1;
        while(true){
            //System.out.println(left + " = " + right);
            if(left + 1 == right){
                break;
            }else{
                int center = (left + right) / 2;
                int tmp = nums[center];
                if(tmp >= nums[left]){
                    left = center;
                }else{
                    right = center;
                }
            }
        }
        return left + 1;
    }

    public int getCenterIdx(int[] nums){
        int lens = nums.length;
        if(nums[0] < nums[lens - 1]) return 0;
        int left = 0;
        int right = lens - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] > nums[left]) left = mid;
            else right = mid;
        }
        return left + 1;
    }

    public int search(int[] nums, int target){
        if(nums.length == 0) return -1;
        int lens = nums.length;
        int left = 0;
        int right = lens - 1;
        int idx = getCenterIdx(nums);
        while(left <= right){
            int mid = (left + right) / 2;
            int realIdx = (mid + idx) % lens;
            if(nums[realIdx] == target) return realIdx;
            else if(nums[realIdx] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public int search2(int[] nums, int target){
        if(nums.length == 0) return -1;
        int lens = nums.length;
        int left = 0;
        int right = lens - 1;
        int idx = getCenterIdx(nums);
        //System.out.println("idx = " + idx);
        if(idx == 0) {
            if(nums[0] == target) return 0;
            return secondIndex(nums, left, right, target);
        } else {
            if(nums[left] <= target && nums[idx - 1] >= target){
                right = idx - 1;
                return secondIndex(nums, left, right, target);
            } else {
                left = idx;
                return secondIndex(nums, left, right, target);
            }
        }
    }

    public int secondIndex(int[] nums, int left, int right, int target){
        if(left < 0 || right > nums.length - 1 || right < left) return -1;
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        if(target > nums[right]) return -1;
        if(target < nums[left]) return -1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        int lens = nums.length - 1;
        int left = 0;
        int right = lens;
        while(left <= right){
            int mid = (left + right) / 2;
            System.out.println(left + ", " + mid + ", " + right);
            if(nums[mid] == target) return mid;
            if(mid == left){
                if(nums[right] == target) return right;
                else break;
            }
            if(mid == right){
                if(nums[left] == target) return left;
                else break;
            }
            // 该范围数组有序
            if(nums[right] > nums[left]){
                if(nums[mid] > target){
                    right = mid;
                } else {
                    left = mid;
                }
            } else { // 该范围数组两段有序
                if(nums[mid] > nums[left]){ // 处于前段内
                    if(target >= nums[left] && target < nums[mid]){
                        right = mid;
                    } else {
                        left = mid;
                    }
                } else { // 处于后段内
                    if(target > nums[mid] && target <= nums[right]){
                        left = mid;
                    } else {
                        right = mid;
                    }
                }
            }
        }
        return -1;
    }
}
