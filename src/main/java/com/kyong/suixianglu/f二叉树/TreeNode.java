package com.kyong.suixianglu.f二叉树;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/6/5 17:21
 */
public class TreeNode {
    TreeNode() {};
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    int val;
    TreeNode left;
    TreeNode right;
}
