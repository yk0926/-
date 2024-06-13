package com.kyong.suixianglu.f二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/6/13 19:52
 */
//102.二叉树的层序遍历
public class c二叉树的层序遍历 {
    //迭代
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if(root == null) return null;
        ArrayList<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            ArrayList<Integer> layer = new ArrayList<>();
            int len = que.size();
            while (len>0){
                TreeNode node = que.poll();
                layer.add(node.val);
                if(node.left!=null){
                    que.offer(node.left);
                }
                if (node.right!=null){
                    que.offer(node.right);
                }
                len--;
            }
            res.add(layer);
        }
        return res;
    }

    //递归
    ArrayList<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {

        digui(root,0);
        return res;
    }

    private void digui(TreeNode node,Integer deep) {
        if(node==null) return;
        deep++;
        if(res.size()<deep){
            ArrayList<Integer> list = new ArrayList<>();
            res.add(list);
        }
        res.get(deep-1).add(node.val);
        digui(node.left,deep);
        digui(node.right,deep);

    }

}
