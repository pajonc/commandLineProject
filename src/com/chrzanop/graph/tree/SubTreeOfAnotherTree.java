package com.chrzanop.graph.tree;

public class SubTreeOfAnotherTree {


    public boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        } else if (isSameTree(root, subRoot))
            return true;
        else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    private boolean isSameTree(Node root, Node subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null && subRoot != null || root != null && subRoot == null) {
            return false;
        } else if (root.data != subRoot.data) {
            return false;
        }
        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);

    }


}
