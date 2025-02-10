package com.chrzanop.coding.algoexpert.binarytrees;

import java.util.*;

public class FlattenBinaryTree3 {


    // O(n) time | O(n) space
    public static BinaryTree flattenBinaryTree(BinaryTree root) {

        return getNodesInOrderIteratively(root);
    }

    private static BinaryTree getNodesInOrderIteratively(BinaryTree node) {
        BinaryTree prevNode = null;
        BinaryTree firstnode = null;
        boolean firstNodeCheck = true;
        Deque<BinaryTree> stack = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            if (node.left != null && !visited.contains(node.left.value)) {
                stack.push(node.left);
                node = node.left;
                continue;
            }
            node = stack.pop();
            visited.add(node.value);
            if (firstNodeCheck) {
                firstnode = node;
                node.left = prevNode;
                prevNode = node;
                firstNodeCheck = false;
            } else {
                node.left = prevNode;
                prevNode.right = node;
                prevNode = node;
            }
            if (node.right != null) {
                stack.push(node.right);
                node = node.right;
            }
        }

        return firstnode;
    }

    private static void getNodesInOrder(BinaryTree node, BinaryTree prevNode, BinaryTree firstNode) {
        if (node.left != null) {
            getNodesInOrder(node.left, prevNode, firstNode);
        }
        if (prevNode != null) {
            node.left = prevNode;
            prevNode.right = node;
            prevNode = node;
        } else {
            node.left = prevNode;
            firstNode = node;
            prevNode = node;
        }
        if (node.right != null) {
            getNodesInOrder(node.right, prevNode, firstNode);
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
