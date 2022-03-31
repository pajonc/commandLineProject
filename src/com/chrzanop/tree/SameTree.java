package com.chrzanop.tree;

public class SameTree {

    public static void main(String[] args) {
        Node b = new Node(2);
        Node c = new Node(3);
        Node a = new Node(b, c, 1);

        Node b1 = new Node(2);
        Node c1 = new Node(3);
        Node a1 = new Node(b1, c1, 1);

        System.out.println(isSameTree(a, a1));
    }

    public static boolean isSameTree(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null && b != null || b == null & a != null) {
            return false;
        } else if (a.data != b.data) {
            return false;
        } else {
            return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
        }

    }
}
