package com.chrzanop.coding.algoexpert.binarytrees;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class NodeDepths {

    // O(n) time | O(h) space
    // n - number of nodes, h - height of Binary Tree
    public static int nodeDepthsIterative(BinaryTree root) {
        int sumOfDepths = 0;
        Deque<Level> stack = new LinkedList<>();
        stack.push(new Level(root, 0));
        while (!stack.isEmpty()) {
            Level node = stack.pop();
            sumOfDepths += node.depth;
            if (node.tree.right != null) {
                stack.push(new Level(node.tree.right, node.depth + 1));
            }
            if (node.tree.left != null) {
                stack.push(new Level(node.tree.left, node.depth + 1));
            }
        }
        return sumOfDepths;
    }


    static class Level {
        BinaryTree tree;
        int depth;

        public Level(BinaryTree tree, int depth) {
            this.tree = tree;
            this.depth = depth;
        }
    }


    public static int nodeDepths(BinaryTree root) {
        return nodeDepths(root, 0);
    }

    static int nodeDepths(BinaryTree root, int depth) {
        if (root == null) {
            return 0;
        }
        return depth + nodeDepths(root.left, depth + 1) + nodeDepths(root.right, depth + 1);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    @Test
    public void TestCase1() {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);
        root.left.right = new BinaryTree(5);
        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        int actual = nodeDepths(root);
        int actual2 = nodeDepthsIterative(root);
        assertEquals(16, actual);
        assertEquals(16, actual2);

        BinaryTree root2 = new BinaryTree(1);
        root2.left = new BinaryTree(2);
        root2.right = new BinaryTree(3);
        assertEquals(2, nodeDepths(root2));
        assertEquals(2, nodeDepthsIterative(root2));


    }
}
