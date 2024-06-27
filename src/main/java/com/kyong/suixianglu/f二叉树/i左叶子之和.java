package com.kyong.suixianglu.f二叉树;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/6/27 16:14
 */
//404.左叶子之和
public class i左叶子之和 {
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        digui(root);
        return res;
    }

    private void digui(TreeNode root) {
        if(root == null) return;
        if(root.left!=null && root.left.left==null && root.left.right==null ){
            res+=root.left.val;
        }
        digui(root.left);
        digui(root.right);
    }
}
