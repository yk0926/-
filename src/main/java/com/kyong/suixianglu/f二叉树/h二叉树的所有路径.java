package com.kyong.suixianglu.f二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/6/26 15:05
 */
//257. 二叉树的所有路径
public class h二叉树的所有路径 {
    ArrayList<String> resList = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return resList;
        dfs(root,new StringBuilder());
        return resList;
    }

    public void dfs(TreeNode root, StringBuilder res){
        if(root.left == null && root.right == null){
            res.append(root.val);
            resList.add(res.toString());
            return;
        }
        res.append(root.val).append("->");
        if(root.left!=null) dfs(root.left,new StringBuilder(res));
        if(root.right!=null) dfs(root.right,new StringBuilder(res));
    }
}
