package com.kyong.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kyong
 * @date 2023/2/16 14:34
 */
public class No2341 {

    public static void main(String[] args) {
        int[] ints = new int[]{1,3,2,1,3,2,2};
        int[] result = numberOfPairs(ints);
        System.out.println(Arrays.toString(result));
    }
//2341
    public static int[] numberOfPairs(int[] nums) {
        int count = 0;
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(numsMap.get(nums[i])==null){
                numsMap.put(nums[i],1);
            }else {
                numsMap.remove(nums[i]);
                count++;
            }
        }
        int[] result = new int[2];
        result[0]=count;
        result[1]=numsMap.size();
        return result;
    }
}
