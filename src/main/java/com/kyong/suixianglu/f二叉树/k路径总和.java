package com.kyong.suixianglu.f二叉树;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/7/2 10:10
 */
//112. 路径总和
public class k路径总和 {
    boolean flag = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        dfs(root,0, targetSum);
        return flag;
    }

    public void dfs(TreeNode node, int sum, int targetSum) {
        if(flag) return;
        sum += node.val;
        if (node.left == null && node.right == null) {
            if (sum == targetSum) {
                flag = true;
            }
            return;
        }
        if (node.left != null) dfs(node.left, sum, targetSum);
        if (node.right != null) dfs(node.right, sum, targetSum);
    }
}
