package com.chrzanop.coding.algoexpert.binarytrees;

public class HeightBalancedBinaryTree {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        public int height;
        public boolean isBalanced;

        public TreeInfo(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    // O(n) time | O(h) space - where n is the number of node in the binary tree
    // and h is the max height of the tree
    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        return getTreeInfo(tree).isBalanced;
    }

    public TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(-1, true);
        }

        TreeInfo left = getTreeInfo(tree.left);
        TreeInfo right = getTreeInfo(tree.right);
        int heightDifference = Math.abs(left.height - right.height);
        int height = Math.max(left.height, right.height) + 1;
        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1;
       return new TreeInfo(height, isBalanced);
    }

}
