package com.chrzanop.coding.algoexpert.binarytrees;

import java.util.ArrayList;
import java.util.Stack;

public class SymmetricalTree {


    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }


    // O(n) time | O(h) space - n number of nodes, h height of the tree
    public boolean symmetricalTree_Algo1(BinaryTree tree) {
        Stack<BinaryTree> stackLeft = new Stack<>();
        Stack<BinaryTree> stackRight = new Stack<>();

        stackLeft.push(tree.left);
        stackRight.push(tree.right);
        while (!stackLeft.isEmpty() && !stackRight.isEmpty()) {
            BinaryTree left = stackLeft.pop();
            BinaryTree right = stackRight.pop();
            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null || left.value != right.value) {
                return false;
            }

            stackLeft.push(left.left);
            stackLeft.push(left.right);
            stackRight.push(right.right);
            stackRight.push(right.left);
        }

        return stackLeft.isEmpty() && stackRight.isEmpty();
    }

    // O(n) time | O(h) space - n number of nodes, h height of the tree
    public boolean symmetricalTree_Algo2(BinaryTree tree) {
        if (tree == null) return false;
        return treesAreMirrored(tree.left, tree.right);
    }

    public boolean treesAreMirrored(BinaryTree treeLeft, BinaryTree treeRight) {
        if (treeLeft != null && treeRight != null && treeLeft.value == treeRight.value) {
            return treesAreMirrored(treeLeft.left, treeRight.right) && treesAreMirrored(treeLeft.right, treeRight.left);
        }
        return treeLeft == treeRight;
    }


    // O(n) time | O(h) space - n number of nodes, h height of the tree
    public boolean symmetricalTree_Mine(BinaryTree tree) {
        ArrayList<Integer> listLeft = new ArrayList<>();
        ArrayList<Integer> listRight = new ArrayList<>();

        inOrderTraversalLeft(tree.left, listLeft);
        inOrderTraversalRight(tree.right, listRight);

        return listLeft.equals(listRight);
    }

    private void inOrderTraversalLeft(BinaryTree tree, ArrayList<Integer> inOrderList) {
        if (tree == null) {
            return;
        }
        inOrderTraversalLeft(tree.left, inOrderList);
        inOrderList.add(tree.value);
        inOrderTraversalLeft(tree.right, inOrderList);
    }

    private void inOrderTraversalRight(BinaryTree tree, ArrayList<Integer> inOrderList) {
        if (tree == null) {
            return;
        }
        inOrderTraversalRight(tree.right, inOrderList);
        inOrderList.add(tree.value);
        inOrderTraversalRight(tree.left, inOrderList);
    }

}
