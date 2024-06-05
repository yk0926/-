package com.kyong.suixianglu.e栈与队列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/6/5 11:30
 */
//347.前 K 个高频元素
public class f前K个高频元素 {
    public static void main(String[] args) {
        int[] ints = {4,1,-1,2,-1,2,3};
        topKFrequent(ints,2);
    }
    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i],0)+1);
        }
        LinkedList<Integer> count = new LinkedList<>();
        Integer[] array = freqMap.values().toArray(new Integer[0]);
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int point = array[k-1];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue()>=point && index<k){
                res[index]=entry.getKey();
                index++;
            }
        }
        return res;
    }
    public  int[] topKFrequent1(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[]> ints = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        LinkedList<Integer> count = new LinkedList<>();
        Integer[] array = freqMap.values().toArray(new Integer[0]);
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int point = array[k-1];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue()>=point && index<k){
                res[index]=entry.getKey();
                index++;
            }
        }
        return res;
    }
}
