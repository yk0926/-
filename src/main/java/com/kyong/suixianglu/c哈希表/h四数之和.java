package com.kyong.suixianglu.c哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/5/20 16:43
 */
//18.四数之和
public class h四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(nums.length < 4){
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0 && nums[i]>target){
                return res;
            }
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                if(nums[i]+nums[j] >target && (nums[i]>=0||nums[j]>=0)){
                    break;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum>target){
                        right -- ;
                    }else if(sum<target){
                        left ++ ;
                    }else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;
                        left++;
                        right--;
                    }
                }

            }
        }
        return res;
    }
}
