package com.kyong.suixianglu.f二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/6/6 16:29
 */
public class a二叉树的递归遍历 {
    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
        return res;

    }

    public void preorder(TreeNode root,List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }

    //后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
        return res;
    }

    public void postorder(TreeNode root,List<Integer> res){
        if(root == null){
            return;
        }
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }

    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
        return res;
    }

    public void inorder(TreeNode root,List<Integer> res){
        if(root == null){
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }

}
