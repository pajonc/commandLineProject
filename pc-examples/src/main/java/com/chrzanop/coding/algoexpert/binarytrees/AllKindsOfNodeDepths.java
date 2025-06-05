package com.chrzanop.coding.algoexpert.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class AllKindsOfNodeDepths {

    // Average case: when tree is balanced
    // O(nlog(n)) time | O(h) space - where n is the number of nodes in
    // the Binary Tree and hi is the height of the Binary Tree

    public static int allKindsOfNodeDepths(BinaryTree root) {
        List<Integer> sums = new ArrayList<>();
        dfsInOrder(root, sums);
        return sums.stream().reduce(0, (subtotal, element) -> subtotal + element);
    }

    static void dfsInOrder(BinaryTree tree, List<Integer> sums) {
        if (tree == null) {
            return;
        }
        dfsInOrder(tree.left, sums);
        int sumCalculated = dfsCount(tree, 0);
        sums.add(sumCalculated);
        dfsInOrder(tree.right, sums);
    }

    static int dfsCount(BinaryTree tree, int depth) {
        if (tree == null) {
            return 0; // depth 0
        }
        int dfsLeft = dfsCount(tree.left, depth + 1);
        int dfsRight = dfsCount(tree.right, depth + 1);
        int depthOnNode = depth + dfsLeft + dfsRight;
        return depthOnNode;
    }


    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        int depth; // added

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }


}
