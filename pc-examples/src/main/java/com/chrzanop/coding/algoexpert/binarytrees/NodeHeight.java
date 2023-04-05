package com.chrzanop.coding.algoexpert.binarytrees;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NodeHeight {

    // O(n) time | O(h) space
    // n - number of nodes, h - height of Binary Tree
    // height of a tree == max depth of a tree
    public static int findHeight(BinaryTree root) {
        if(root == null) return -1;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    @Test
    public void TestCase1() {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);
        root.left.right = new BinaryTree(5);
        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        int actual = findHeight(root);
        assertEquals(3, actual);

    }
}
