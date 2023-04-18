package com.chrzanop.coding.algoexpert.binarytrees;

import org.junit.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeDiameterTest {

    @Test
    public void TestCase1() {
        TestBinaryTree input = new TestBinaryTree(1);
        input.insert(new int[] {2, 3, 4, 5, 6, 7}, 0);
        int expected = 4;
        int actual = new BinaryTreeDiameter().binaryTreeDiameter(input);
        assertTrue(expected == actual);
    }

    class TestBinaryTree extends BinaryTreeDiameter.BinaryTree {
        public TestBinaryTree(int value) {
            super(value);
        }

        public void insert(int[] values, int i) {
            if (i >= values.length) {
                return;
            }
            ArrayDeque<BinaryTreeDiameter.BinaryTree> queue = new ArrayDeque<BinaryTreeDiameter.BinaryTree>();
            queue.addLast(this);
            while (queue.size() > 0) {
                BinaryTreeDiameter.BinaryTree current = queue.pollFirst();
                if (current.left == null) {
                    current.left = new BinaryTreeDiameter.BinaryTree(values[i]);
                    break;
                }
                queue.addLast(current.left);
                if (current.right == null) {
                    current.right = new BinaryTreeDiameter.BinaryTree(values[i]);
                    break;
                }
                queue.addLast(current.right);
            }
            insert(values, i + 1);
        }
    }

}