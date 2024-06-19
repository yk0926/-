package com.kyong.suixianglu.g回溯算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/6/17 11:38
 */
//第77题. 组合
public class a组合 {
    //自己写的
    public static void main(String[] args) {
        System.out.println(combine(30,25));
    }
    static ArrayList<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {
        for (int i = 1; i <= n-k+1; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(i);
            back(temp, k-1, i+1 , n);
        }
        return  res;
    }

    public static void back(List<Integer> temp, int k,int j ,int max){
        if(k==0) {
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        for (int i = j; i <= max-k+1; i++) {
            temp.add(i);
            back(temp,k-1, i+1, max);
        }
        temp.remove(temp.size()-1);
    }


    //题解
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine1(int n, int k) {
        combineHelper(n, k, 1);
        return result;
    }

    /**
     * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
     * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
     */
    private void combineHelper(int n, int k, int startIndex){
        //终止条件
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
            path.add(i);
            combineHelper(n, k, i + 1);
            path.removeLast();
        }
    }
}

