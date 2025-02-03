package com.chrzanop.coding.algoexpert.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTree2 {

    public static void main(String[] args) {

    }

    // O(n) time | O(n) space
    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        List<BinaryTree> inOrderNodes = getNodesInOrder(root, new ArrayList<>());
        BinaryTree prevNode = null;
        for (int i = 0; i < inOrderNodes.size() - 1; i++) {
            BinaryTree leftNode = inOrderNodes.get(i);
            BinaryTree rightNode = inOrderNodes.get(i + 1);
            leftNode.right = rightNode;
            rightNode.left = leftNode;
        }
        return inOrderNodes.get(0);
    }

    private static List<BinaryTree> getNodesInOrder(BinaryTree node, List<BinaryTree> trees) {
        if (node != null) {
            getNodesInOrder(node.left, trees);
            trees.add(node);
            getNodesInOrder(node.right, trees);
        }
        return trees;
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
