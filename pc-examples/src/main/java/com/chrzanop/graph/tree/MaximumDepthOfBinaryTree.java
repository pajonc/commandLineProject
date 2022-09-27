package com.chrzanop.graph.tree;

import java.util.*;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree mdoft = new MaximumDepthOfBinaryTree();
        TreeNode root = mdoft.setupTreeNode();
        System.out.println(mdoft.maxDepth(root));
        System.out.println("-------------");
//        mdoft.traverseBFS(root);
    }

    private TreeNode setupTreeNode() {
        TreeNode tn11 = new TreeNode(11);
        TreeNode tn9 = new TreeNode(9, tn11, null);
        TreeNode tn13 = new TreeNode(13);
        TreeNode tn15 = new TreeNode(15);
        TreeNode tn20 = new TreeNode(20, tn13, tn15);
        TreeNode treeNode = new TreeNode(3, tn9, tn20);
        return treeNode;
    }

//                3
//              9   20
//          11    13  15
//




    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return Math.max(left, right) + 1;
    }

    public void traverseBFS(TreeNode node) {
        if(node==null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();

            System.out.println(poll.val);
            if(poll.left != null) {
                queue.add(poll.left);
            }
            if(poll.right != null) {
                queue.add(poll.right);
            }

        }
    }

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
