package com.kyong.suixianglu.f二叉树;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/7/1 9:43
 */
//#513.找树左下角的值
public class j找树左下角的值 {
    int maxDepth = 0;
    TreeNode res;
    public int findBottomLeftValue(TreeNode root) {
        if(root==null) return 0;
        dfs(root,0);
        return res.val;
    }

    public void dfs(TreeNode node,int deep){
        if(node == null) return;
        if(node.left == null && node.right ==null){
            if(deep > maxDepth){
                maxDepth = deep;
                res = node;
            }
        }
        deep++;
        dfs(node.left,deep);
        dfs(node.right,deep);
    }
}
