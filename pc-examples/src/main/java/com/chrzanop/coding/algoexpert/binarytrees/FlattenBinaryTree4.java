package com.chrzanop.coding.algoexpert.binarytrees;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class FlattenBinaryTree4 {

    // O(n) time | O(d) space where d is the height of the tree
    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        BinaryTree[] leftAndRightMost = flattenTree(root);

        return leftAndRightMost[0];
    }

    private static BinaryTree[] flattenTree(BinaryTree node){
        BinaryTree leftMost;
        BinaryTree rightMost;

        if(node.left == null) {
            leftMost = node;
        } else {
            BinaryTree[] leftAndRightMost = flattenTree(node.left);
            connectNodes(leftAndRightMost[1], node);
            leftMost = leftAndRightMost[0];
        }

        if(node.right == null) {
            rightMost = node;
        } else {
            BinaryTree[] leftAndRightMost = flattenTree(node.right);
            connectNodes(node, leftAndRightMost[0]);
            rightMost = leftAndRightMost[1];
        }

        return new BinaryTree[] {leftMost, rightMost};
    }

    private static void connectNodes (BinaryTree left, BinaryTree right) {
        left.right = right;
        right.left = left;
    }

//    private static BinaryTree link(BinaryTree node) {
//
//        BinaryTree leftMost = getLeftMost(node.right);
//        BinaryTree rightMost = getRightMost(node.left);
//
//    }

//    private static BinaryTree getRightMost(BinaryTree node) {
//        if (node.right != null) {
//            getRightMost(node.right);
//        }
//        return node;
//    }
//
//    private static BinaryTree getLeftMost(BinaryTree node) {
//        if (node.left != null) {
//            getRightMost(node.left);
//        }
//        return node;
//    }
//
//    private static void getNodesInOrder(BinaryTree node) {
//        if (node != null) {
//            getNodesInOrder(node.left);
//            System.out.println(node.value);
//            getNodesInOrder(node.right);
//        }
//    }

    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
