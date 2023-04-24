package com.chrzanop.coding.algoexpert.binarytrees;

import java.util.Deque;
import java.util.LinkedList;

public class MergeBinaryTrees {


    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(n) time | O(h) space - where n is the number of nodes in the smaller of the two trees
    // and h is height of the shorterTree
    public BinaryTree mergeBinaryTrees_Algo1(BinaryTree tree1, BinaryTree tree2) {
        if (tree1 == null) return tree2;
        if (tree2 == null) return tree1;
        tree1.value +=tree2.value;
        tree1.left = mergeBinaryTrees_Algo1(tree1.left, tree2.left);
        tree1.right = mergeBinaryTrees_Algo1(tree1.right, tree2.right);
        return tree1;
    }

    // O(n) time | O(h) space - where n is the number of nodes in the smaller of the two trees
    // and h is height of the shorterTree
    public BinaryTree mergeBinaryTrees_Algo2(BinaryTree tree1, BinaryTree tree2) {

        Deque<BinaryTree> tree1Stack = new LinkedList<>();
        Deque<BinaryTree> tree2Stack = new LinkedList<>();
        tree1Stack.push(tree1);
        tree2Stack.push(tree2);

        while (!tree1Stack.isEmpty()) {
            BinaryTree tree1Node = tree1Stack.pop();
            BinaryTree tree2Node = tree2Stack.pop();
            if (tree2Node == null) {
                continue;
            }
            tree1Node.value += tree2Node.value;
            if (tree1Node.left == null) {
                tree1Node.left = tree2Node.left;
            } else {
                tree1Stack.push(tree1Node.left);
                tree2Stack.push(tree2Node.left);
            }

            if (tree1Node.right == null) {
                tree1Node.right = tree2Node.right;
            } else {
                tree1Stack.push(tree1Node.right);
                tree2Stack.push(tree2Node.right);
            }

        }
        return tree1;
    }


}
