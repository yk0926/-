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
        HashMap<Integer,Integer> sumMap = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len-2; i++) {
            for (int j = i+1; j < len -1; j++) {
                for (int k = j+1; k < len; k++) {
                    if(nums[i]+nums[j]+nums[k]==0){
                        int[] ints = {nums[i], nums[j], nums[k]};
                        Arrays.sort(ints);
                        if(sumMap.get(ints[0])!=null && Objects.equals(sumMap.get(ints[0]), ints[1])){
                            continue;
                        }else {
                            sumMap.put(ints[0],ints[1]);
                            res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        }
                    }
                }
            }
        }
        return res;
    }
}
