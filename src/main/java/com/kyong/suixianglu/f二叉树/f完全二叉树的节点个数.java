package com.kyong.suixianglu.f二叉树;

import java.util.LinkedList;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/6/24 15:15
 */
//222.完全二叉树的节点个数
public class f完全二叉树的节点个数 {

    public int countNodes1(TreeNode root) {
        int res = 0;
        if(root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size> 0){
                TreeNode node = queue.pop();
                res++;
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
                size--;
            }
        }
        return res;
    }

    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}


