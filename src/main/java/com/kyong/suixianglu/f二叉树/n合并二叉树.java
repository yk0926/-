package com.kyong.suixianglu.f二叉树;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/7/12 13:50
 */
//617.合并二叉树
public class n合并二叉树 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }
        TreeNode cur =new TreeNode(0);
        if (root1 == null){
            cur.val = root2.val;
            cur.left =mergeTrees(null,root2.left);
            cur.right =mergeTrees(null,root2.right);
        }else if(root2 == null){
            cur.val = root1.val;
            cur.left =mergeTrees(root1.left,null);
            cur.right =mergeTrees(root1.right,null);
        }else {
            cur.val = root1.val+root2.val;
            cur.left =mergeTrees(root1.left,root2.left);
            cur.right =mergeTrees(root1.right,root2.right);
        }
        return cur;
    }


    public TreeNode dfs(TreeNode root1, TreeNode root2){
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = dfs(root1.left, root2.left);
        root.right = dfs(root1.right, root2.right);
        return root;
    }

}
