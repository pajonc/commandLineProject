package com.chrzanop.coding.algoexpert.binarysearchtrees;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ValidateBST {

    // O(n) time | O(d) space where d is stack size and n number of verticies(nodes) to visit
    public static boolean validateBst(BST tree) {
        return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean validateBst(BST tree, int min, int max) {

        if (!isValid(tree.value, min, max)) {
            return false;
        }
        if (tree.left != null && !validateBst(tree.left, min, tree.value)) {
            return false;
        }
        if (tree.right != null && !validateBst(tree.right, tree.value, max)) {
            return false;
        }
        return true;
    }



    static boolean isValid(int value, int min, int max) {
        return value >= min && value < max ? true : false;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }


    static void printPreOrder(BST root) {
        System.out.println(root.value);
        if (root.left != null) {
            printPreOrder(root.left);
        }
        if (root.right != null) {
            printPreOrder(root.right);
        }

    }

    static void printInOrder(BST root) {
        if (root.left != null) {
            printInOrder(root.left);
        }
        System.out.println(root.value);
        if (root.right != null) {
            printInOrder(root.right);
        }
    }

    static void printPostOrder(BST root) {
        if (root.left != null) {
            printPostOrder(root.left);
        }
        if (root.right != null) {
            printPostOrder(root.right);
        }
        System.out.println(root.value);
    }


    @Test
    public void TestCase1() {
        BST root = buidTree();
        assertTrue(validateBst(root));
    }

    private static BST buidTree() {
        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);
        return root;
    }

    public static void main(String[] args) {
        BST bst = buidTree();
        printPreOrder(bst);
        System.out.println("===============");
        printInOrder(bst);
        System.out.println("===============");
        printPostOrder(bst);
    }
}
