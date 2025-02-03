package com.chrzanop.coding.algoexpert.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTree {

    // O(n) time | O(n) space
    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        // Write your code here.
        ArrayList<BinaryTree> trees = new ArrayList<>();
        inOrder(root, trees);

        BinaryTree prevNode = null;
        for (int i = 0; i < trees.size(); i++) {
            BinaryTree node = trees.get(i);
            node.left = prevNode;
            node.right = i + 1 < trees.size() ? trees.get(i + 1) : null;
            prevNode = node;
        }

        return trees.get(0);
    }

    private static void inOrder(BinaryTree node, List<BinaryTree> trees) {
        if (node.left != null) {
            inOrder(node.left, trees);
        }
        System.out.println(node.value);
        trees.add(node);
        if (node.right != null) {
            inOrder(node.right, trees);
        }
    }

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
