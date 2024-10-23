package com.chrzanop.coding.algoexpert.binarysearchtrees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumBstTest {

    @Test
    public void TestCase1() {
        SumBst.BinaryTree root = new SumBst.BinaryTree(8);
        root.left = new SumBst.BinaryTree(2);
        root.left.left = new SumBst.BinaryTree(1);
        root.left.right = new SumBst.BinaryTree(10);
        root.right = new SumBst.BinaryTree(9);
        root.right.right = new SumBst.BinaryTree(5);
        int expected = 13;
        int actual = new SumBst().sumBsts(root);
        assertTrue(expected == actual);
    }

}