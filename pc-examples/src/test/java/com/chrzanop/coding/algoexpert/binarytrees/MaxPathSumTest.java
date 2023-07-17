package com.chrzanop.coding.algoexpert.binarytrees;

import org.junit.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.*;

public class MaxPathSumTest {

    @Test
    public void TestCase1() {
        TestBinaryTree test = new TestBinaryTree(1);
        test.insert(new int[] {2, 3, 4, 5, 6, 7}, 0);
        assertTrue(MaxPathSum.maxPathSum(test) == 18);
    }

    class TestBinaryTree extends MaxPathSum.BinaryTree {
        public TestBinaryTree(int value) {
            super(value);
        }

        public void insert(int[] values, int i) {
            if (i >= values.length) {
                return;
            }
            ArrayDeque<MaxPathSum.BinaryTree> queue = new ArrayDeque<MaxPathSum.BinaryTree>();
            queue.addLast(this);
            while (queue.size() > 0) {
                MaxPathSum.BinaryTree current = queue.pollFirst();
                if (current.left == null) {
                    current.left = new MaxPathSum.BinaryTree(values[i]);
                    break;
                }
                queue.addLast(current.left);
                if (current.right == null) {
                    current.right = new MaxPathSum.BinaryTree(values[i]);
                    break;
                }
                queue.addLast(current.right);
            }
            insert(values, i + 1);
        }
    }
    

}