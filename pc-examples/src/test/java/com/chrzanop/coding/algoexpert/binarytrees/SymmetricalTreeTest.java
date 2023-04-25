package com.chrzanop.coding.algoexpert.binarytrees;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SymmetricalTreeTest {

    @Test
    public void TestCase1() {
        SymmetricalTree.BinaryTree tree = new SymmetricalTree.BinaryTree(10);
        tree.left = new SymmetricalTree.BinaryTree(5);
        tree.right = new SymmetricalTree.BinaryTree(5);
        tree.left.left = new SymmetricalTree.BinaryTree(7);
        tree.left.right = new SymmetricalTree.BinaryTree(9);
        tree.right.left = new SymmetricalTree.BinaryTree(9);
        tree.right.right = new SymmetricalTree.BinaryTree(7);
        boolean expected = true;
        SymmetricalTree symmetricalTree = new SymmetricalTree();
        boolean actual = symmetricalTree.symmetricalTree_Mine(tree);
        boolean actual_algo1 = symmetricalTree.symmetricalTree_Algo1(tree);
        boolean actual_algo2 = symmetricalTree.symmetricalTree_Algo2(tree);
        assertTrue(expected == actual);
        assertTrue(expected == actual_algo1);
        assertTrue(expected == actual_algo2);
    }

}