package com.chrzanop.coding.algoexpert.binarytrees;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeightBalancedBinaryTreeTest {

    @Test
    public void TestCase1() {
        HeightBalancedBinaryTree.BinaryTree root = new HeightBalancedBinaryTree.BinaryTree(1);
        root = new HeightBalancedBinaryTree.BinaryTree(1);
        root.left = new HeightBalancedBinaryTree.BinaryTree(2);
        root.right = new HeightBalancedBinaryTree.BinaryTree(3);
        root.left.left = new HeightBalancedBinaryTree.BinaryTree(4);
        root.left.right = new HeightBalancedBinaryTree.BinaryTree(5);
        root.right.right = new HeightBalancedBinaryTree.BinaryTree(6);
        root.left.right.left = new HeightBalancedBinaryTree.BinaryTree(7);
        root.left.right.right = new HeightBalancedBinaryTree.BinaryTree(8);
        boolean expected = true;
        boolean actual = new HeightBalancedBinaryTree().heightBalancedBinaryTree(root);
        assertTrue(expected == actual);
    }

}