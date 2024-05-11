package com.kyong.suixianglu.a数组;

import java.util.Arrays;

/**
 * @author kyong
 * @date 2023/3/24 14:43
 */
public class c有序数组的平方 {
    //977.有序数组的平方
    public int[] sortedSquares(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            nums[i]=Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            nums[i]= nums[i]*nums[i];
        }
        return nums;
    }
    //双指针
    public int[] sortedSquares2(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int j = 0;
        int k = nums.length-1;
        while (j <= k ){
            length--;
            if(nums[j]*nums[j]>nums[k]*nums[k]){
                result[length] = nums[j]*nums[j];
                j++;
            }else {
                result[length] = nums[k]*nums[k];
                k--;
            }
        }
        return result;
    }
}
