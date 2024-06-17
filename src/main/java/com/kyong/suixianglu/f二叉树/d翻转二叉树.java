package com.kyong.suixianglu.f二叉树;

import java.util.LinkedList;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/6/17 10:43
 */
//226.翻转二叉树
public class d翻转二叉树 {
    //bfs
    public TreeNode invertTree1(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root==null) return root;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                TreeNode node = queue.poll();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
                size --;
            }
        }
        return root;
    }
    //dfs 递归
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        dfs(root);
        return root;
    }

    public void dfs(TreeNode node){
        if(node == null) return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        if(node.left!= null) dfs(node.left);
        if(node.right!= null) dfs(node.right);
    }

}
