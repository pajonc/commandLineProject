package com.chrzanop.coding.algoexpert.binarysearchtrees;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindClosestValueInBst {

    public static int findClosestValueInBstRecursive(BST tree, int target) {
        return findClosestValueInBstRecursive(tree, target, tree.value);
    }

    public static int findClosestValueInBstRecursive(BST tree, int target, int closest) {

        int currentValue = tree.value;
        if (Math.abs(target - closest) > Math.abs(target - currentValue)) {
            closest = tree.value;
        }

        if (currentValue < target && tree.right != null) {
            // right
            return findClosestValueInBstRecursive(tree.right, target, closest);
        } else if (currentValue > target && tree.left != null) {
            //left
            return findClosestValueInBstRecursive(tree.left, target, closest);
        } else {
            return closest;
        }
    }


    // Average: O(log(n)) time | O(1) space
    // Worst: O(n) time | O(1) space - if tree not balanced
    public static int findClosestValueInBst(BST tree, int target) {
        int closest = tree.value;
        BST currentTree = tree;
        int currentValue;

        while (currentTree != null) {
            currentValue = currentTree.value;
            int diff1 = Math.abs(closest - target);
            int diff2 = Math.abs(currentValue - target);
            if (diff1 > diff2) {
                closest = currentValue;
            }
            if (currentValue < target) {
                // right
                currentTree = currentTree.right;
            } else if (currentValue > target) {
                //left
                currentTree = currentTree.left;
            } else {
                break;
            }
        }
        return closest;
    }


    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    @Test
    public void TestCase1() {
        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);

        int expected = 13;
        int actual = findClosestValueInBst(root, 12);
        int actualR = findClosestValueInBstRecursive(root, 12);
        assertEquals(expected, actual);
        assertEquals(expected, actualR);
    }

}
