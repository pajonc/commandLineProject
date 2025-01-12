package com.chrzanop.coding.algoexpert.binarytrees;

import java.util.*;

public class FindNodesDistanceK_DFS {

    static class BinaryTree {
        public int value;
        public FindNodesDistanceK_DFS.BinaryTree left = null;
        public FindNodesDistanceK_DFS.BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(n) time | O(n) space
    public ArrayList<Integer> findNodesDistanceK(FindNodesDistanceK_DFS.BinaryTree tree, int target, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        findDistanceFromNodeToTarget(tree, target, k, result);

        return result;
    }

    private int findDistanceFromNodeToTarget(FindNodesDistanceK_DFS.BinaryTree node, int target, int k, ArrayList<Integer> nodesDistanceK) {
        if (node == null) return -1;

        if (node.value == target) {
            addSubtreeNodesAtDistanceK(node, k, 0, nodesDistanceK);
            return 1;
        }

        int leftDistance = findDistanceFromNodeToTarget(node.left, target, k, nodesDistanceK);
        int rightDistance = findDistanceFromNodeToTarget(node.right, target, k, nodesDistanceK);

        if (leftDistance == k || rightDistance == k) nodesDistanceK.add(node.value);

        if (leftDistance != -1) {
            addSubtreeNodesAtDistanceK(node.right, k, leftDistance + 1, nodesDistanceK);
            return leftDistance + 1;
        }
        if (rightDistance != -1) {
            addSubtreeNodesAtDistanceK(node.left, k, rightDistance + 1, nodesDistanceK);
            return rightDistance + 1;
        }
        return -1;
    }

    private void addSubtreeNodesAtDistanceK(FindNodesDistanceK_DFS.BinaryTree node, int k, int distance, ArrayList<Integer> nodesDistanceK) {
        if (node == null) {
            return;
        }
        if (distance == k) {
            nodesDistanceK.add(node.value);
        } else {
            addSubtreeNodesAtDistanceK(node.left, k, distance + 1, nodesDistanceK);
            addSubtreeNodesAtDistanceK(node.right, k, distance + 1, nodesDistanceK);
        }
    }


}
