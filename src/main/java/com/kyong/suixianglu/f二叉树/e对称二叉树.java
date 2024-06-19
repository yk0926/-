package com.kyong.suixianglu.f二叉树;

import java.util.LinkedList;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/6/19 15:38
 */
//101. 对称二叉树
public class e对称二叉树 {
    public boolean isSymmetric1(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null)  return true;
        if(root.left == null && root.right==null){return true;}
        if(root.right == null || root.left == null){return false;}
        queue.offer(root.right);
        queue.offer(root.left);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = 0;
            int end = size-1;
            while (start<end){
                if(queue.get(start).val!=queue.get(end).val){return false;}
                start++;
                end--;
            }
            while (size>0){
                TreeNode node = queue.pop();
                if(node.val != -101){
                    if (node.left == null){
                        queue.offer(new TreeNode(-101));
                    }else {
                        queue.offer(node.left);
                    }
                    if (node.right == null){
                        queue.offer(new TreeNode(-101));
                    }else {
                        queue.offer(node.right);
                    }
                }
                size--;
            }
        }
        return true;
    }


    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode left,TreeNode right) {
        if (left==null && right == null) return true;
        if(left ==null || right ==null || left.val != right.val) return false;
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }
}
