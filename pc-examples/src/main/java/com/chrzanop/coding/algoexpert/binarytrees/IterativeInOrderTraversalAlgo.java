package com.chrzanop.coding.algoexpert.binarytrees;

import java.util.function.Function;

public class IterativeInOrderTraversalAlgo {


    public static void iterativeInOrderTraversal(
            BinaryTree tree, Function<BinaryTree, Void> callback
    ) {
        BinaryTree currentNode = tree;
        BinaryTree prevNode = null;
        while(currentNode != null) {
            BinaryTree nextNode = null;
            if(prevNode == null || prevNode == currentNode.parent) {
                if(currentNode.left != null) {
                    nextNode = currentNode.left;
                } else {
                    callback.apply(currentNode);
                    nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
                }
            } else if (prevNode == currentNode.left) {
                callback.apply(currentNode);
                nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;

            } else if (prevNode == currentNode.right) {
                nextNode = currentNode.parent;
            }
            prevNode = currentNode;
            currentNode = nextNode;
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
