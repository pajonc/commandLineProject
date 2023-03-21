package com.chrzanop.coding.algoexpert.binarytrees;

import java.util.ArrayDeque;

public class InvertBinaryTree {

    // O(n) time | O(d) space where d is depth of binary tree and n number of nodes
    public static void invertBinaryTree(BinaryTree tree) {
        if (tree == null) {
            return;
        }
        swapTree(tree);
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

    // O(n) time | O(n) space
    public static void invertBinaryTreeIteratively(BinaryTree tree) {
        ArrayDeque<BinaryTree> queue = new ArrayDeque<>();
        queue.addLast(tree);
        while (!queue.isEmpty()) {
            BinaryTree current = queue.pollFirst();
            if (current == null) {
                continue;
            }
            swapTree(current);
            if (current.left != null) queue.addLast(current.left);
            if (current.right != null) queue.addLast(current.right);
        }
    }


    private static void swapTree(BinaryTree tree) {
        BinaryTree treeRight = tree.right;
        tree.right = tree.left;
        tree.left = treeRight;
    }


//    public static void invertBinaryTree(BinaryTree tree) {
//        BinaryTree inverted = new BinaryTree(tree.value);
//        invertBinaryTree(tree, inverted);
//        tree = inverted;
//    }
//
//    static void invertBinaryTree(BinaryTree tree, BinaryTree inverted) {
//        if(tree==null) {
//            return;
//        }
//        if(tree.left!=null) {
//            inverted.right = new BinaryTree(tree.left.value);
//            invertBinaryTree(tree.left, inverted.right);
//        }
//
//        if(tree.right!=null) {
//            inverted.left = new BinaryTree(tree.right.value);
//            invertBinaryTree(tree.right, inverted.left);
//        }
//
//    }


    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
