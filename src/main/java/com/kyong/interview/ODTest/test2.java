package com.kyong.interview.ODTest;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author kyong
 * @date 2023/3/19 8:41
 */

/*
*
* 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。找出只出现一次的那两个元素，你可以按 任意顺序 返回答案.
示例 1:
输入: nums = [1,2,1,3,2,5]
输出: [3,5]
解释: [5,3] 也是有效的答案。
示例 2:
输入: nums =[-1,0]
输出: [-1,0]
示例 3:
输入: nums = [0,1]
输出: [1,0]
* */
public class test2 {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1};
        int[] integers = returnTwoNumber(arr);
        System.out.println(Arrays.toString(integers));
    }

    static  int[] returnTwoNumber(int[] arr){
        HashMap<Integer, Integer> numberMap = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if(numberMap.get(arr[i])==null){
                numberMap.put(arr[i],1);
            }else if(numberMap.get(arr[i])==1){
                numberMap.remove(arr[i]);
            }
        }
        int i= 0;
        for (Integer integer : numberMap.keySet()) {
            res[i]=integer;
            i++;
        }
        return res;
    }
}
