package com.chrzanop.coding.algoexpert.binarytrees;

import java.util.Map;

public class BinaryTreeParentAppend {


    public BinaryTree parentAppender(BinaryTree root) {
        populateNodesToParents(root, null);
        return root;
    }


    private void populateNodesToParents(BinaryTree binaryTree, BinaryTree parent) {
        binaryTree.parent = parent;
        if (binaryTree.left != null) {
            populateNodesToParents(binaryTree.left, binaryTree);
        }
        if (binaryTree.right != null) {
            populateNodesToParents(binaryTree.right, binaryTree);
        }
    }

    static class BinaryTree {
        int value;
       BinaryTree left = null;
       BinaryTree right = null;
       BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
