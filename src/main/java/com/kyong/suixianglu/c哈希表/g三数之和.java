package com.kyong.suixianglu.c哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/5/17 16:32
 */
//15.三数之和
public class g三数之和 {
    public static void main(String[] args) {
        int[] ints = {-1, 0, 1, 2, -1, -4};
        threeSum(ints);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i]>0){
                break;
            }
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j<k) {
                int sum = nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                }else if (sum>0){
                    k -- ;
                }else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j<k && nums[j]==nums[j+1]){
                        j++;
                    }
                    while (i<k && nums[k] == nums[k-1]){
                        k--;
                    }
                    j++;
                    k--;
                }
            }
        }
        return res;
    }
}
