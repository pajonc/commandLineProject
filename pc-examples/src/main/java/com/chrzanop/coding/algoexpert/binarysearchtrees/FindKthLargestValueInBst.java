package com.chrzanop.coding.algoexpert.binarysearchtrees;

import java.util.ArrayList;
import java.util.List;

public class FindKthLargestValueInBst {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    // O(n) time | O(n) space - where n is number of nodes in the tree
    public int findKthLargestValueInBst(BST tree, int k) {
        List<Integer> inOrderBst = new ArrayList<>();
        findKthLargestValueInBst(tree, inOrderBst);

        int size = inOrderBst.size();
        int idx = size - k;

        return size > 0 ? inOrderBst.get(idx) : -1;
    }

    public void findKthLargestValueInBst(BST tree, List<Integer> list) {

        if (tree == null) return;

        if (tree.left != null) {
            findKthLargestValueInBst(tree.left, list);
        }
        list.add(tree.value);
        if (tree.right != null) {
            findKthLargestValueInBst(tree.right, list);
        }
    }

    // O(h+k) time | O(h) space - where h is the height of the tree and k input parameter
    // optimal, reverse inOrder traversal
    public int findKthLargestValueInBstOptimal(BST tree, int k) {
        TreeInfo treeInfo = new TreeInfo(0, -1);
        reverseInOrderTraverse(tree, treeInfo, k);
        return treeInfo.lastVisitedValue;
    }

    private void reverseInOrderTraverse(BST tree, TreeInfo treeInfo, int k) {
        if (tree == null || treeInfo.numberOfNodesVisited >= k) {
            return;
        }

        reverseInOrderTraverse(tree.right, treeInfo, k);
        if (treeInfo.numberOfNodesVisited < k) {
            treeInfo.lastVisitedValue = tree.value;
            treeInfo.numberOfNodesVisited += 1;
            reverseInOrderTraverse(tree.left, treeInfo, k);
        }
    }


    static class TreeInfo {
        public int numberOfNodesVisited;
        public int lastVisitedValue;

        public TreeInfo(int numberOfNodesVisited, int lastVisitedValue) {
            this.numberOfNodesVisited = numberOfNodesVisited;
            this.lastVisitedValue = lastVisitedValue;
        }
    }

}
