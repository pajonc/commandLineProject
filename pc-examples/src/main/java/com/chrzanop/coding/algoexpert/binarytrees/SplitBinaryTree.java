package com.chrzanop.coding.algoexpert.binarytrees;

public class SplitBinaryTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class ResultPair {
        public int value;
        public boolean canBeSplit;

        public ResultPair(int value, boolean canBeSplit) {
            this.value = value;
            this.canBeSplit = canBeSplit;
        }
    }

    // O(n) time | O(h) space - n number of nodes, h height of the tree
    public int splitBinaryTree(BinaryTree tree) {
        int treeSum = getTreeSum(tree);

        if (treeSum % 2 != 0) {
            return 0;
        }
        int desiredSubTreeSum = treeSum / 2;

        boolean canBeSplit = trySubtrees(tree, desiredSubTreeSum).canBeSplit;
        return canBeSplit ? desiredSubTreeSum : 0;
    }

    private ResultPair trySubtrees(BinaryTree tree, int desiredSubTreeSum) {
        if (tree == null) {
            return new ResultPair(0, false);
        }
        ResultPair leftSum = trySubtrees(tree.left, desiredSubTreeSum);
        ResultPair rightSum = trySubtrees(tree.right, desiredSubTreeSum);

        int currentTreeSum = tree.value + leftSum.value + rightSum.value;
        boolean isSplit = leftSum.canBeSplit
                || rightSum.canBeSplit
                || currentTreeSum == desiredSubTreeSum;

        return new ResultPair(currentTreeSum, isSplit);
    }

    private int getTreeSum(BinaryTree tree) {
        if (tree == null) {
            return 0;
        }
        return tree.value + getTreeSum(tree.left) + getTreeSum(tree.right);
    }

}
