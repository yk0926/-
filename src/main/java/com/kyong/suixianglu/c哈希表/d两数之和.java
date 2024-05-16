package com.kyong.suixianglu.c哈希表;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/5/16 16:19
 */
//1.两数之和
public class d两数之和 {
    public static void main(String[] args) {
        twoSum(new int[]{3,2,4},6);
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if(numsMap.get(res)!=null){
                return new int[]{i,numsMap.get(res)};
            }else {
                numsMap.put(nums[i],i);
            }
        }
        return null;
    }
}
