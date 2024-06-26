package com.kyong.suixianglu.f二叉树;

import java.util.ArrayList;
import java.util.Collections;
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

//107. 二叉树的层序遍历 II
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(null == root) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            ArrayList<Integer> layer = new ArrayList<>();
            while (len>0){
                TreeNode node = queue.poll();
                layer.add(node.val);
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
                len--;
            }
            res.add(layer);
        }
        Collections.reverse(res);
        return res;
    }

    //199. 二叉树的右视图
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                if(size == 1){
                    res.add(node.val);
                }
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
                size--;
            }
        }
        return res;
    }

//637. 二叉树的层平均值
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int size1 = queue.size();
            long sum = 0;
            while (size > 0){
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
                size--;
            }
            res.add((double)sum/size1);
        }
        return res;
    }

    //515. 在每个树行中找最大值
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            while (size > 0){
                TreeNode node = queue.poll();
                max = max > node.val? max : node.val;
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
                size--;
            }
            res.add(max);
        }
        return res;
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
//116. 填充每个节点的下一个右侧节点指针
    public Node connect(Node root) {
        if (root==null) return root;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Node cur = queue.peek();
            while (size > 0){
                Node node = queue.poll();
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
                if(cur != node ){
                    cur.next = node;
                    cur = node;
                }
                size--;
            }
            cur.next = null;
        }
        return root;
    }

    //104. 二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int deep =0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
                size--;
            }
            deep++;
        }
        return deep;
    }

    //111. 二叉树的最小深度
    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int deep =0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                if(node.left==null&& node.right==null) return deep;
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
                size--;
            }
            deep++;
        }
        return deep;
    }
}
