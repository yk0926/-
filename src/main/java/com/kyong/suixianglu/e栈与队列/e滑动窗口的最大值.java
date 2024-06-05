package com.kyong.suixianglu.e栈与队列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/6/4 20:19
 */
public class e滑动窗口的最大值 {
    //超时
    public int[] maxSlidingWindow1(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<Integer> window = new LinkedList<>();
        int len = nums.length;
        for (int i = 0; i < k; i++) {
            window.add(nums[i]);
        }
        res.add(compare(window));
        for (int i = k; i < len; i++) {
            window.removeFirst();
            window.addLast(nums[i]);
            res.add(compare(window));
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int compare(LinkedList<Integer> window){
        int res = window.getFirst();
        for (int i = 1; i < window.size(); i++) {
            if(res < window.get(i)){
                res = window.get(i);
            }
        }
        return res;
    }

    //单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i]>deque.peekLast()){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            if(i>=k && nums[i-k] == deque.peekFirst()){
                deque.removeFirst();
            }
            if(i>=k-1){
                res[i-k+1]  = deque.peekFirst();
            }
        }
        return res;
    }
}
