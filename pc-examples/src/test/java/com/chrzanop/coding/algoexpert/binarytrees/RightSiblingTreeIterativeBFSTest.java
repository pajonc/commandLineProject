package com.chrzanop.coding.algoexpert.binarytrees;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RightSiblingTreeIterativeBFSTest {

    @Test
    public void TestCase1() {
        RightSiblingTreeIterativeBFS.BinaryTree root = new RightSiblingTreeIterativeBFS.BinaryTree(1);
        insert(root, new int[] {2, 3, 4, 5, 6, 7, 8, 9});
        root.left.right.right = new RightSiblingTreeIterativeBFS.BinaryTree(10);
        root.right.left.left = new RightSiblingTreeIterativeBFS.BinaryTree(11);
        root.right.right.left = new RightSiblingTreeIterativeBFS.BinaryTree(12);
        root.right.right.right = new RightSiblingTreeIterativeBFS.BinaryTree(13);
        root.right.left.left.left = new RightSiblingTreeIterativeBFS.BinaryTree(14);
        RightSiblingTreeIterativeBFS.BinaryTree mutatedRoot = RightSiblingTreeIterativeBFS.rightSiblingTree(root);
        List<Integer> actual = getDfsOrder(mutatedRoot);
        var expected = Arrays.asList(
                1, 2, 4, 8, 9, 5, 6, 11, 14, 7, 12, 13, 3, 6, 11, 14, 7, 12, 13
        );
        assertTrue(expected.equals(actual));
    }

    public void insert(RightSiblingTreeIterativeBFS.BinaryTree root, int[] values) {
        insert(root, values, 0);
    }

    public void insert(RightSiblingTreeIterativeBFS.BinaryTree root, int[] values, int i) {
        if (i >= values.length) {
            return;
        }
        Deque<RightSiblingTreeIterativeBFS.BinaryTree> queue = new ArrayDeque<RightSiblingTreeIterativeBFS.BinaryTree>();
        queue.addLast(root);
        while (queue.size() > 0) {
            RightSiblingTreeIterativeBFS.BinaryTree current = queue.pollFirst();
            if (current.left == null) {
                current.left = new RightSiblingTreeIterativeBFS.BinaryTree(values[i]);
                break;
            }
            queue.addLast(current.left);
            if (current.right == null) {
                current.right = new RightSiblingTreeIterativeBFS.BinaryTree(values[i]);
                break;
            }
            queue.addLast(current.right);
        }
        insert(root, values, i + 1);
    }

    public List<Integer> getDfsOrder(RightSiblingTreeIterativeBFS.BinaryTree tree) {
        List<Integer> values = new ArrayList<Integer>();
        values.add(tree.value);
        if (tree.left != null) {
            values.addAll(getDfsOrder(tree.left));
        }
        if (tree.right != null) {
            values.addAll(getDfsOrder(tree.right));
        }
        return values;
    }


}