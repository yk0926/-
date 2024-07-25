package com.kyong.suixianglu.f二叉树;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/7/25 14:40
 */
//700.二叉搜索树中的搜索
public class o二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val) return root;
        if(root.val>val) return searchBST(root.left, val);
        return searchBST(root.right, val);
    }
}
