package com.chrzanop.coding.algoexpert.binarytrees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllKindsOfNodeDepthsTest {

    @Test
    public void TestCase1() {
        var root = new AllKindsOfNodeDepths.BinaryTree(1);
        root.left = new AllKindsOfNodeDepths.BinaryTree(2);
        root.left.left = new AllKindsOfNodeDepths.BinaryTree(4);
        root.left.left.left = new AllKindsOfNodeDepths.BinaryTree(8);
        root.left.left.right = new AllKindsOfNodeDepths.BinaryTree(9);
        root.left.right = new AllKindsOfNodeDepths.BinaryTree(5);
        root.right = new AllKindsOfNodeDepths.BinaryTree(3);
        root.right.left = new AllKindsOfNodeDepths.BinaryTree(6);
        root.right.right = new AllKindsOfNodeDepths.BinaryTree(7);
        int actual = AllKindsOfNodeDepths.allKindsOfNodeDepths(root);
        assertEquals(26, actual);
    }

    @Test
    public void TestCase2() {
        var root = new AllKindsOfNodeDepths.BinaryTree(1);
        root.left = new AllKindsOfNodeDepths.BinaryTree(2);
        root.left.left = new AllKindsOfNodeDepths.BinaryTree(4);
        root.left.left.left = new AllKindsOfNodeDepths.BinaryTree(8);
        root.left.left.right = new AllKindsOfNodeDepths.BinaryTree(9);
        root.left.right = new AllKindsOfNodeDepths.BinaryTree(5);
        root.right = new AllKindsOfNodeDepths.BinaryTree(3);
        root.right.left = new AllKindsOfNodeDepths.BinaryTree(6);
        root.right.right = new AllKindsOfNodeDepths.BinaryTree(7);
        int actual = AllKindsOfNodeDepths.allKindsOfNodeDepthsFaster(root);
        System.out.println(actual);
    }

}