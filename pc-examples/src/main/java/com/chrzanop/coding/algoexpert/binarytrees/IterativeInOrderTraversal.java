package com.chrzanop.coding.algoexpert.binarytrees;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class IterativeInOrderTraversal {


    public static void iterativeInOrderTraversal(
            BinaryTree tree, Function<BinaryTree, Void> callback
    ) {
        BinaryTree currentNode = tree;
        BinaryTree prevNode = null;
        if (tree == null) return;

        if (currentNode.left != null) {
            prevNode = currentNode;
            currentNode = currentNode.left;
        } else if (currentNode.right != null) {
            callback.apply(currentNode);
            prevNode = currentNode;
            currentNode = currentNode.right;
        }

        while (currentNode != null) {
            if (currentNode.parent != null && currentNode.parent == prevNode && currentNode.left != null) {
                prevNode = currentNode;
                currentNode = currentNode.left;
            } else if (currentNode.parent != null && currentNode.parent == prevNode) {
                if (currentNode.left == null) {
                    callback.apply(currentNode);
                }
                if (currentNode.right != null) {
                    prevNode = currentNode;
                    currentNode = currentNode.right;
                } else {
                    prevNode = currentNode;
                    currentNode = currentNode.parent;
                }
            } else if (currentNode.parent != null && currentNode.parent != prevNode) {
                if (currentNode.left == prevNode) {
                    callback.apply(currentNode);
                }
                if (currentNode.right == prevNode) {
                    prevNode = currentNode;
                    currentNode = currentNode.parent;
                } else if (currentNode.right != null && currentNode.right != prevNode) {
                    prevNode = currentNode;
                    currentNode = currentNode.right;
                } else if (currentNode.right == null) {
                    prevNode = currentNode;
                    currentNode = currentNode.parent;
                }
            } else if (currentNode.parent == null && currentNode.left == prevNode) {
                callback.apply(tree);
                if (currentNode.right != null) {
                    prevNode = currentNode;
                    currentNode = currentNode.right;
                }
            } else if (currentNode.parent == null && currentNode.right == prevNode) {
                currentNode = null;
            }
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree parent;

        public BinaryTree(int value) {
            this.value = value;
        }

        public BinaryTree(int value, BinaryTree parent) {
            this.value = value;
            this.parent = parent;
        }
    }


}
