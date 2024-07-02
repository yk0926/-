package com.kyong.suixianglu.g回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/7/2 11:32
 */
//39. 组合总和
public class d组合总和 {
    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        combinationSum(candidates,7);
    }
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> temp =new LinkedList<>();
    public  static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        back(candidates,target,0);
        return res;
    }

    public static void back(int[] candidates, int target, int index){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(target < candidates[index]){
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            temp.add(candidates[i]);
            back(candidates,target-candidates[i],i);
            temp.removeLast();
        }
    }
}
