package com.kyong.suixianglu.h贪心算法;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/7/2 10:59
 */
//53. 最大子序和
public class c最大子序和 {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if(length ==1) return nums[0];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum+=nums[i];
            if(sum> max) max = sum;
            if(sum<=0) sum =0;
        }
        return max;
    }
}
