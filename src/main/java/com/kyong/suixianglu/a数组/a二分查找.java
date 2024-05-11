package com.kyong.suixianglu.a数组;

public class a二分查找 {
    //704 二分查找
    public int search(int[] nums, int target) {
        if(nums[0]>target||nums[nums.length-1]<target){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (right+left)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                right = mid-1;
            }
            if(nums[mid]<target){
                left = mid+1;
            }
        }
        return -1;
    }
}
