package com.kyong.suixianglu.f二叉树;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/7/4 16:14
 */
//654. 最大二叉树
public class m最大二叉树 {
    public static void main(String[] args) {
        m最大二叉树 m最大二叉树 = new m最大二叉树();
        int[] nums = new int[]{3,2,1,6,0,5};
        m最大二叉树.constructMaximumBinaryTree(nums);
    }
    Map<Integer, Integer> map = new HashMap<Integer,Integer>();
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        return build(nums,0,nums.length-1);
    }


    public TreeNode build(int[] nums, int start, int end){
        if(start>end) return null;
        int max = findMax(nums, start, end);
        int maxIndex = map.get(max);
        TreeNode root = new TreeNode(max);
        root.left =build(nums,start,maxIndex-1);
        root.right =build(nums,maxIndex+1,end);
        return root;


    }

    public int findMax(int[] nums, int start, int end){
        int max = nums[start];
        for (int i = start+1; i <= end; i++) {
            if(max < nums[i]){
                max = nums[i];
            }
        }
        return max;
    }
}
