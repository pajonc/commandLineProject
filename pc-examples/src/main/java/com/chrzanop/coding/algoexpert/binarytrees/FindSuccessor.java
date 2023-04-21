package com.chrzanop.coding.algoexpert.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class FindSuccessor {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(h) time | O(1) space - where h is the height of the tree
    public BinaryTree findSuccessorAlgo2(BinaryTree tree, BinaryTree node) {
        if (node.right != null) return getLeftMostChild(node.right);
        return getRightMostParent(node);
    }

    private BinaryTree getLeftMostChild(BinaryTree node) {
        BinaryTree currentNode = node;
        while (currentNode.left!=null) {
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    private BinaryTree getRightMostParent(BinaryTree node) {
        BinaryTree currentNode = node;
        while(currentNode.parent !=null && currentNode.parent.right == currentNode) {
            currentNode = currentNode.parent;
        }
        return currentNode.parent;
    }

    // O(n) time | O(n) space - where n is the number of nodes in the tree
    public BinaryTree findSuccessorAlgo1(BinaryTree tree, BinaryTree node) {

        List<BinaryTree> inOrderTraversal = new ArrayList<>();
        getInOrderTraversalOrder(tree, inOrderTraversal);

        for (int i = 0; i < inOrderTraversal.size(); i++) {
            if (inOrderTraversal.get(i) != node) {
                continue;
            }

            if (i == inOrderTraversal.size() - 1) return null;

            return inOrderTraversal.get(i + 1);
        }

        return null;
    }

    public void getInOrderTraversalOrder(BinaryTree tree, List<BinaryTree> inOrderTraversal) {
        if (tree == null) {
            return;
        }
        getInOrderTraversalOrder(tree.left, inOrderTraversal);
        inOrderTraversal.add(tree);
        getInOrderTraversalOrder(tree.right, inOrderTraversal);
    }

}
