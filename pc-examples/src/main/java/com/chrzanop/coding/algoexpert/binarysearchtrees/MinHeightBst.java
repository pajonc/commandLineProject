package com.chrzanop.coding.algoexpert.binarysearchtrees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MinHeightBst {

    // O(n) time | O(n) space
    public static BST minHeightBstLinear(List<Integer> array) {
        return constructMinHeightBst(array, 0, array.size() - 1, null);
    }

    public static BST constructMinHeightBstLinear(List<Integer> array, int startIdx, int endIdx, BST bst) {
        if (endIdx < startIdx) {
            return null;
        }
        int midIdx = (startIdx + endIdx) / 2;
        BST newBstNode = new BST(array.get(midIdx));
        if (bst == null) {
            bst = newBstNode;
        } else {
            if (array.get(midIdx) < bst.value) {
                bst.left = newBstNode;
                bst = bst.left;
            } else {
                bst.right = newBstNode;
                bst = bst.right;
            }
        }
        //left
        constructMinHeightBstLinear(array, startIdx, midIdx - 1, bst);
        //right
        constructMinHeightBstLinear(array, midIdx + 1, endIdx, bst);
        return bst;
    }


    // O(n*log(n)) time | O(n) space - n length of an array
    public static BST minHeightBst(List<Integer> array) {
        return constructMinHeightBst(array, 0, array.size() - 1, null);
    }

    public static BST constructMinHeightBst(List<Integer> array, int startIdx, int endIdx, BST root) {
        if (endIdx >= startIdx) {
            int midIdx = (startIdx + endIdx) / 2;
            if (root == null) {
                root = new BST(array.get(midIdx));
            } else {
                root.insert(array.get(midIdx));
            }
            //left
            constructMinHeightBst(array, startIdx, midIdx - 1, root);
            // right
            constructMinHeightBst(array, midIdx + 1, endIdx, root);
        }
        return root;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }


    @Test
    public void TestCase1() {
        List<Integer> array = Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22);
        BST tree = minHeightBst(array);
        BST tree2 = minHeightBstLinear(array);

        assertTrue(validateBst(tree));


        assertEquals(4, getTreeHeight(tree));
        assertEquals(4, getTreeHeight(tree2));
        assertEquals(4, getBstHeight(tree));

        List<Integer> inOrder = inOrderTraverse(tree, new ArrayList<Integer>());
        List<Integer> inOrder2 = inOrderTraverse(tree2, new ArrayList<Integer>());
        List<Integer> expected = Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22);
        assertTrue(expected.equals(inOrder));
        assertTrue(expected.equals(inOrder2));
    }

    static boolean validateBst(BST tree) {
        return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean validateBst(BST tree, int minValue, int maxValue) {
        if (tree.value < minValue || tree.value >= maxValue) {
            return false;
        }
        if (tree.left != null && !validateBst(tree.left, minValue, tree.value)) {
            return false;
        }
        if (tree.right != null && !validateBst(tree.right, tree.value, maxValue)) {
            return false;
        }
        return true;
    }

    static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if (tree.left != null) {
            inOrderTraverse(tree.left, array);
        }
        array.add(tree.value);
        if (tree.right != null) {
            inOrderTraverse(tree.right, array);
        }
        return array;
    }

    static int getBstHeight(BST tree) {
        return getBstHeight(tree, 0);

    }

    static int getBstHeight(BST tree, int height) {
        if (tree == null) {
            return 0;
        }
        int leftHeight = getBstHeight(tree.left, height + 1);
        int rightHeight = getBstHeight(tree.right, height + 1);
        return Math.max(leftHeight, rightHeight) + 1;

    }

    static int getTreeHeight(BST tree) {
        return getTreeHeight(tree, 0);
    }

    static int getTreeHeight(BST tree, int height) {
        if (tree == null) return height;
        int leftTreeHeight = getTreeHeight(tree.left, height + 1);
        int rightTreeHeight = getTreeHeight(tree.right, height + 1);
        return Math.max(leftTreeHeight, rightTreeHeight);
    }

}
