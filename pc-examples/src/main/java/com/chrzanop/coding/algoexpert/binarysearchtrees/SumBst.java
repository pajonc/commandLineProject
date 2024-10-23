package com.chrzanop.coding.algoexpert.binarysearchtrees;

import java.util.List;

public class SumBst {


    public int sumBsts(BinaryTree tree) {
        TreeInfo treeInfo = getTreeInfo(tree);
        return treeInfo.totalSumBsts;
    }

    public static TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, 0);
        }

        TreeInfo leftTree = getTreeInfo(tree.left);
        TreeInfo rightTree = getTreeInfo(tree.right);

        boolean satisfiesBstProp = tree.value > leftTree.maxValue && tree.value <= rightTree.minValue;
        boolean isBst = satisfiesBstProp & leftTree.isBst & rightTree.isBst;

        int maxValue = Math.max(tree.value, Math.max(leftTree.maxValue, rightTree.maxValue));
        int minValue = Math.min(tree.value, Math.min(leftTree.minValue, rightTree.minValue));
        int bstSum = 0;
        int bstSize = 0;

        int totalSumBstNodes = leftTree.totalSumBsts + rightTree.totalSumBsts;

        if (isBst) {
            bstSum = tree.value + leftTree.bstSum + rightTree.bstSum;
            bstSize = 1 + leftTree.bstSize + rightTree.bstSize;

            if(bstSize>=3) {
                totalSumBstNodes = bstSum;
            }
        }

        return new TreeInfo(isBst, maxValue, minValue, bstSum, bstSize, totalSumBstNodes);
    }

//    public static TreeInfo postOrderTraverse(BinaryTree tree) {
//        if(tree.left!=null){
//            postOrderTraverse(tree.left);
//        }
//        if(tree.right!=null) {
//            postOrderTraverse(tree.right);
//        }
//        return calculateTreeInfo(tree);
//    }


//    private static TreeInfo calculateTreeInfo(BinaryTree tree) {
//        TreeInfo treeInfo = new TreeInfo();
//        treeInfo.isBst = isBst(tree, treeInfo);
//
//
//        return treeInfo;
//    }

    private static boolean isBst(BinaryTree tree, TreeInfo treeInfo) {
        if ((tree.left != null && tree.left.value < tree.value && tree.right != null && tree.right.value >= tree.value) || (tree.left == null && tree.right == null)) {
            return true;
        } else {
            return false;
        }
    }

    static class TreeInfo {
        public TreeInfo(boolean isBst, int maxValue, int minValue, int bstSum, int bstSize, int totalSumBsts) {
            this.isBst = isBst;
            this.maxValue = maxValue;
            this.minValue = minValue;
            this.bstSum = bstSum;
            this.bstSize = bstSize;
            this.totalSumBsts = totalSumBsts;
        }

        public boolean isBst;
        public int maxValue;
        public int minValue;
        public int bstSum;
        public int bstSize;
        public int totalSumBsts;
    }

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
