package com.kyong.suixianglu.g回溯算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/6/19 16:39
 */
//216.组合总和III
public class b组合总和III {
    static  ArrayList<List<Integer>> res = new ArrayList<>();
    static  List<Integer> temp = new ArrayList<>();
    static int sum = 0;
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        back(1, n, k);
        return res;
    }

    public static void back(int index ,int n, int k){
        if(temp.size() == k ){
            if(sum == n){
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = index; i < 11-(k-temp.size()) ; i++) {
            sum+=i;
            temp.add(i);
            back(i+1, n, k);
            sum-=i;
            temp.remove(temp.size()-1);
        }
    }

}
