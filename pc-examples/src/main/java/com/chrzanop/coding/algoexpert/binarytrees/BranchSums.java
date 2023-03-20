package com.chrzanop.coding.algoexpert.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // O(n) time | O(n) space - where n is the number of nodes in Binary Tree
    public static List<Integer> calculateBranchSums(BinaryTree root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        calculateBranchSums(root, list, 0);
        return list;
    }

    private static void calculateBranchSums(BinaryTree node, ArrayList<Integer> sums, int runningSum) {
        // recursive case
        if (node == null) {
            return;
        }
        int newRunningSum = runningSum + node.value;
        //base case
        if (node.left == null && node.right == null) {
            sums.add(newRunningSum);
            return;
        }
        calculateBranchSums(node.left, sums, newRunningSum);
        calculateBranchSums(node.right, sums, newRunningSum);
    }


}
