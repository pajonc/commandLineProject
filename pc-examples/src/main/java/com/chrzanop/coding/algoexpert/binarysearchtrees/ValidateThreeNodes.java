package com.chrzanop.coding.algoexpert.binarysearchtrees;

public class ValidateThreeNodes {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    // O(h) time | O(h) space - where h is the height of the tree
    public boolean validateThreeNodes_Mine(BST nodeOne, BST nodeTwo, BST nodeThree) {
        return nodeIsDescendantIterative(nodeOne, nodeTwo) && nodeIsDescendantIterative(nodeTwo, nodeThree) ||
                nodeIsDescendantIterative(nodeThree, nodeTwo) && nodeIsDescendantIterative(nodeTwo, nodeOne);
    }

    // O(h) time | O(h) space - where h is the height of the tree
    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        return isDescendant(nodeOne, nodeTwo) && isDescendant(nodeTwo, nodeThree) ||
                isDescendant(nodeThree, nodeTwo) && isDescendant(nodeTwo, nodeOne);
    }

    private boolean isDescendantIterative(BST node, BST target) {
        while(node != null  && node != target) {
            node = (target.value < node.value) ? node.left : node.right;
        }
        return node==target;
    }

    private boolean nodeIsDescendantIterative(BST nodeOne, BST nodeTwo) {
        while (nodeOne != null && nodeOne.value != nodeTwo.value) {
            if (nodeOne.value == nodeTwo.value) {
                break;
            } else if (nodeOne.value > nodeTwo.value) {
                nodeOne = nodeOne.left;
            } else {
                nodeOne = nodeOne.right;
            }
        }
        return nodeOne != null;
    }

    // whether the target is descendant of the node
    private boolean isDescendant(BST node, BST target) {
        if (node == null) {
            return false;
        }
        if (node == target) {
            return true;
        }
        return node.value > target.value ? isDescendant(node.left, target) : isDescendant(node.right, target);
    }
}
