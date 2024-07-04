package com.kyong.suixianglu.f二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/7/4 14:45
 */
//106. 从中序与后序遍历序列构造二叉树 105.从前序与中序遍历序列构造二叉树
public class l从中序与后序遍历序列构造二叉树 {
    Map<Integer, Integer> map = new HashMap<Integer,Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        if(inorder == null || inorder.length == 0){
            return null;
        }
        return recursion(inorder,0,inorder.length-1,postorder,0,inorder.length-1);
    }

    public TreeNode recursion(int[] inorder, int inBegin, int inEnd,
                              int[] postorder, int postBegin, int postEnd){
        if(inEnd < inBegin || postEnd < postBegin) return null;
        int rootVal = postorder[postEnd];
        int rootIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left=recursion(inorder,inBegin,rootIndex-1,postorder,postBegin,postBegin+rootIndex-1-inBegin);
        root.right=recursion(inorder,rootIndex+1,inEnd,postorder,postBegin+rootIndex-inBegin,postEnd-1);
        return root;
    }


    //105.从前序与中序遍历序列构造二叉树
    public TreeNode buildTree2(int[] inorder, int[] preorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        if(inorder.length == 0){
            return null;
        }
        return build(inorder,0,inorder.length-1,preorder,0,inorder.length-1);
    }

    public TreeNode build(int[] inorder, int inBegin, int inEnd,
                              int[] preorder, int preBegin, int preEnd){
        if(inEnd < inBegin || preEnd < preBegin) return null;
        int rootVal = preorder[preBegin];
        int rootIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left=build(inorder,inBegin,rootIndex-1,preorder,preBegin+1,preBegin+rootIndex-1-inBegin);
        root.right=build(inorder,rootIndex+1,inEnd,preorder,preBegin+1+rootIndex-inBegin,preEnd);
        return root;
    }
}
