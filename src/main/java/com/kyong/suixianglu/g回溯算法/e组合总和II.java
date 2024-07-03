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
 * @date 2024/7/2 19:55
 */
//40.组合总和II
public class e组合总和II {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        back(candidates,target,0);
        return res;
    }

    public void back(int[] candidates, int target, int index){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if(target < candidates[i]){
                break;
            }
            if(i>index && candidates[i] == candidates[i-1]){
                continue;
            }
            temp.add(candidates[i]);
            back(candidates, target - candidates[i], i+1);
            temp.removeLast();
        }
    }
}
