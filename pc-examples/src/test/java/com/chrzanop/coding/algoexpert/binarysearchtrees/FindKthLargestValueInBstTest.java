package com.chrzanop.coding.algoexpert.binarysearchtrees;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FindKthLargestValueInBstTest {

    @Test
    public void TestCase1() {
        FindKthLargestValueInBst.BST root = new FindKthLargestValueInBst.BST(15);
        root.left = new FindKthLargestValueInBst.BST(5);
        root.left.left = new FindKthLargestValueInBst.BST(2);
        root.left.left.left = new FindKthLargestValueInBst.BST(1);
        root.left.left.right = new FindKthLargestValueInBst.BST(3);
        root.left.right = new FindKthLargestValueInBst.BST(5);
        root.right = new FindKthLargestValueInBst.BST(20);
        root.right.left = new FindKthLargestValueInBst.BST(17);
        root.right.right = new FindKthLargestValueInBst.BST(22);
        int k = 3;
        int expected = 17;
        FindKthLargestValueInBst fklv = new FindKthLargestValueInBst();
        int kthLargestValueInBst = fklv.findKthLargestValueInBst(root, k);
        assertTrue(expected == kthLargestValueInBst);

        kthLargestValueInBst = fklv.findKthLargestValueInBstOptimal(root, k);
        assertTrue(expected == kthLargestValueInBst);
    }

}