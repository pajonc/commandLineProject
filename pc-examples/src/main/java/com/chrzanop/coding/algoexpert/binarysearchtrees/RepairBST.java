package com.chrzanop.coding.algoexpert.binarysearchtrees;

public class RepairBST {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    private BST nodeOne = null, nodeTwo = null, prevNode = null;

    // O(n) time | O(h) space - where n is number of nodes
    // and h is the height of the tree
    public BST repairBst(BST tree) {
        traverseInOrder(tree);
        int tempNodeOneValue = this.nodeOne.value;
        this.nodeOne.value = this.nodeTwo.value;
        this.nodeTwo.value = tempNodeOneValue;
        return tree;
    }

    private void traverseInOrder(BST node) {
        if (node == null) {
            return;
        }
        traverseInOrder(node.left);
        if (this.prevNode != null && this.prevNode.value > node.value) {
            if (nodeOne == null) {
                this.nodeOne = this.prevNode;
            }
            this.nodeTwo = node;
        }
        this.prevNode = node;
        traverseInOrder(node.right);
    }
}
