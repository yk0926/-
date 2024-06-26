package com.kyong.suixianglu.f二叉树;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/6/24 15:40
 */
//110.平衡二叉树
public class g平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root){
        if(root == null) return 0;
        int left = getHeight(root.left);
        if(left ==  -1) {
            return -1;
        }
        int right = getHeight(root.right);
        if(right ==  -1) {
            return -1;
        }
        if(Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
