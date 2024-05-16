package com.kyong.suixianglu.c哈希表;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/5/16 16:57
 */
//454.四数相加II
public class e四数相加II {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res =0;
        HashMap<Integer, Integer> sumab = new HashMap<>();
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                sumab.put(a+b, sumab.getOrDefault(a+b,0)+1);
            }
        }
        for (int c : nums3) {
            for (int d : nums4) {
                int left = -c - d;
                    res+=sumab.getOrDefault(left,0);
            }
        }
        return res;
    }
}
