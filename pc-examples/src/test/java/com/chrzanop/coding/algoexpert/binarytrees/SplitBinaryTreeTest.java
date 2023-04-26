package com.chrzanop.coding.algoexpert.binarytrees;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SplitBinaryTreeTest {

    @Test
    public void TestCase1() {
        SplitBinaryTree.BinaryTree tree = new SplitBinaryTree.BinaryTree(2);
        tree.left = new SplitBinaryTree.BinaryTree(4);
        tree.left.left = new SplitBinaryTree.BinaryTree(4);
        tree.left.right = new SplitBinaryTree.BinaryTree(6);
        tree.right = new SplitBinaryTree.BinaryTree(10);
        tree.right.left = new SplitBinaryTree.BinaryTree(3);
        tree.right.right = new SplitBinaryTree.BinaryTree(3);
        int expected = 16;
        int actual = new SplitBinaryTree().splitBinaryTree(tree);
        assertTrue(expected == actual);
    }

}