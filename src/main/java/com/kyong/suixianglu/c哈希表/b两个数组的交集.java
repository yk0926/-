package com.kyong.suixianglu.c哈希表;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/5/14 17:23
 */
//349. 两个数组的交集
public class b两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if(set.contains(i)){
                res.add(i);
            }
        }
        int[] ints = new int[res.size()];
        Integer[] array = res.toArray(new Integer[0]);
        for (int i = 0; i < ints.length; i++) {
            ints[i] = array[i];
       }
        return ints;
    }
}
