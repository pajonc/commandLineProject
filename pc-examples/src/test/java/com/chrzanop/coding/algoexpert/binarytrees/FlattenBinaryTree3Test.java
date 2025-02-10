package com.chrzanop.coding.algoexpert.binarytrees;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FlattenBinaryTree3Test {

    @Test
    public void TestCase1() {
        FlattenBinaryTree3.BinaryTree root = new FlattenBinaryTree3.BinaryTree(1);
        insert(root, new int[] {2, 3, 4, 5, 6});
        root.left.right.left = new FlattenBinaryTree3.BinaryTree(7);
        root.left.right.right = new FlattenBinaryTree3.BinaryTree(8);
        FlattenBinaryTree3.BinaryTree leftMostNode = FlattenBinaryTree3.flattenBinaryTree(root);
        List<Integer> leftToRightToLeft = leftToRightToLeft(leftMostNode);
        List<Integer> expected = new ArrayList<Integer>(
                Arrays.asList(4, 2, 7, 5, 8, 1, 6, 3, 3, 6, 1, 8, 5, 7, 2, 4)
        );
        assertTrue(expected.equals(leftToRightToLeft));
    }

    public void insert(FlattenBinaryTree3.BinaryTree root, int[] values) {
        insert(root, values, 0);
    }

    public void insert(FlattenBinaryTree3.BinaryTree root, int[] values, int i) {
        if (i >= values.length) {
            return;
        }
        Deque<FlattenBinaryTree3.BinaryTree> queue = new ArrayDeque<FlattenBinaryTree3.BinaryTree>();
        queue.addLast(root);
        while (queue.size() > 0) {
            FlattenBinaryTree3.BinaryTree current = queue.pollFirst();
            if (current.left == null) {
                current.left = new FlattenBinaryTree3.BinaryTree(values[i]);
                break;
            }
            queue.addLast(current.left);
            if (current.right == null) {
                current.right = new FlattenBinaryTree3.BinaryTree(values[i]);
                break;
            }
            queue.addLast(current.right);
        }
        insert(root, values, i + 1);
    }

    public List<Integer> leftToRightToLeft(FlattenBinaryTree3.BinaryTree leftMost) {
        List<Integer> nodes = new ArrayList<Integer>();
        FlattenBinaryTree3.BinaryTree current = leftMost;
        while (current.right != null) {
            nodes.add(current.value);
            current = current.right;
        }
        nodes.add(current.value);
        while (current != null) {
            nodes.add(current.value);
            current = current.left;
        }
        return nodes;
    }

}