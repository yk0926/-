package com.kyong.suixianglu.a数组;

/**
 * @author kyong
 * @date 2023/3/24 15:07
 */
//209.长度最小的子数组
    //双指针
public class d长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int slow = 0;
        int fast = 0;
        int res = nums.length+1;
        int temp = 0;
        while (fast<nums.length){
            temp += nums[fast++];
            while (temp>=target){
                res = Math.min(res,fast-slow);
                temp -= nums[slow++];
            }
        }
        return res>nums.length?0:res;
    }
}
