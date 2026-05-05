package com.chrzanop.coding.algoexpert.binarytrees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompareLeafTraversalTest {

    @Test
    public void TestCase1() {
        CompareLeafTraversal.BinaryTree tree1 = new CompareLeafTraversal.BinaryTree(1);
        tree1.left = new CompareLeafTraversal.BinaryTree(2);
        tree1.right = new CompareLeafTraversal.BinaryTree(3);
        tree1.left.left = new CompareLeafTraversal.BinaryTree(4);
        tree1.left.right = new CompareLeafTraversal.BinaryTree(5);
        tree1.right.right = new CompareLeafTraversal.BinaryTree(6);
        tree1.left.right.left = new CompareLeafTraversal.BinaryTree(7);
        tree1.left.right.right = new CompareLeafTraversal.BinaryTree(8);

        CompareLeafTraversal.BinaryTree tree2 = new CompareLeafTraversal.BinaryTree(1);
        tree2.left = new CompareLeafTraversal.BinaryTree(2);
        tree2.right = new CompareLeafTraversal.BinaryTree(3);
        tree2.left.left = new CompareLeafTraversal.BinaryTree(4);
        tree2.left.right = new CompareLeafTraversal.BinaryTree(7);
        tree2.right.right = new CompareLeafTraversal.BinaryTree(5);
        tree2.right.right.left = new CompareLeafTraversal.BinaryTree(8);
        tree2.right.right.right = new CompareLeafTraversal.BinaryTree(6);

        var expected = true;
        var actual = new CompareLeafTraversal().compareLeafTraversal(tree1, tree2);
        assertTrue(expected == actual);
    }

}