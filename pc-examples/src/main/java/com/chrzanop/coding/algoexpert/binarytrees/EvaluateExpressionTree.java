package com.chrzanop.coding.algoexpert.binarytrees;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EvaluateExpressionTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(n) time | O(h) space - where n is the number of nodes in the Binary Tree,
    // and h is the height of the Binary Tree
    public int evaluateExpressionTree(BinaryTree tree) {

        if (tree.value >= 0) {
            return tree.value;
        }

        int left = evaluateExpressionTree(tree.left);
        int right = evaluateExpressionTree(tree.right);
        int result = operate(left, right, tree.value);

        return result;
    }

    int operate(int leftValue, int rightValue, int operand) {
        if (operand == -1) {
            return leftValue + rightValue;
        }
        if (operand == -2) {
            return leftValue - rightValue;
        }
        if (operand == -3) {
            return leftValue / rightValue;
        }
        return leftValue * rightValue;

    }

    @Test
    public void TestCase1() {
        BinaryTree tree = new BinaryTree(-1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(-2);
        tree.right.left = new BinaryTree(5);
        tree.right.right = new BinaryTree(1);
        int expected = 6;
        int actual = evaluateExpressionTree(tree);
        assertTrue(expected == actual);
    }
}
