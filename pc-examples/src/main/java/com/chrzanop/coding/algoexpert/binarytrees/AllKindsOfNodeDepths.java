package com.chrzanop.coding.algoexpert.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class AllKindsOfNodeDepths {

    // Average case: when tree is balanced
    // O(nlog(n)) time | O(h) space - where n is the number of nodes in
    // the Binary Tree and hi is the height of the Binary Tree

    public static int allKindsOfNodeDepths(BinaryTree root) {
        List<Integer> sums = new ArrayList<>();
        dfsInOrder(root, sums);
        return sums.stream().reduce(0, (subtotal, element) -> subtotal + element);
    }

    // O(n) time | O(h) space
    public static int allKindsOfNodeDepthsFaster(BinaryTree root) {
        List<Integer> sums = new ArrayList<>();
        Pair<Integer, Integer> depthVsSum = dfsFormula(root,sums);
        return sums.stream().reduce(0, (subtotal, element) -> subtotal + element);
    }

    static void dfsInOrder(BinaryTree tree, List<Integer> sums) {
        if (tree == null) {
            return;
        }
        dfsInOrder(tree.left, sums);
        int sumCalculated = dfsCount(tree, 0);
        sums.add(sumCalculated);
        dfsInOrder(tree.right, sums);
    }

    static int dfsCount(BinaryTree tree, int depth) {
        if (tree == null) {
            return 0; // depth 0
        }
        int dfsLeft = dfsCount(tree.left, depth + 1);
        int dfsRight = dfsCount(tree.right, depth + 1);
        int depthOnNode = depth + dfsLeft + dfsRight;
        return depthOnNode;
    }

    // nD = nDL + #L + nDR + #R
    // nDL --> node depth Left
    // nDR --> node depth Right
    // #L  --> sum of nodes Left
    // #R  --> sum of nodes Right
    static Pair<Integer, Integer> dfsFormula(BinaryTree tree, List<Integer> sums) {
        if (tree == null) {
            return new Pair<>(0, 0); // depth 0
        }
        Pair<Integer, Integer> dfsLeft = dfsFormula(tree.left, sums);
        int nodeLeft = dfsLeft.sumOfNodes;
        int nDL = dfsLeft.depth;

        Pair<Integer, Integer> dfsRight = dfsFormula(tree.right, sums);
        int nodeRight = dfsRight.sumOfNodes;
        int nDR = dfsRight.depth ;

        sums.add(nDL + nDR + nodeLeft + nodeRight);
        return new Pair<>(nDL + nDR + nodeLeft + nodeRight , nodeLeft + nodeRight + 1);
    }

    static class Pair<U, V> {
        public final U depth;
        public final V sumOfNodes;

        private Pair(U depth, V sum) {
            this.depth = depth;
            this.sumOfNodes = sum;
        }
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        int depth = 0; // added
        int sumOfNodes = 0;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }


}
