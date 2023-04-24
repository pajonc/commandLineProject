package com.chrzanop.coding.algoexpert.binarytrees;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MergeBinaryTreesTest {

    @Test
    public void TestCase1() {
        MergeBinaryTrees.BinaryTree tree1 = createBinaryTree1();
        MergeBinaryTrees.BinaryTree tree2 = createBinaryTree2();

        MergeBinaryTrees.BinaryTree actual = new MergeBinaryTrees().mergeBinaryTrees_Algo1(tree1, tree2);

        assertTrue(actual.value == 2);
        assertTrue(actual.left.value == 8);
        assertTrue(actual.left.left.value == 9);
        assertTrue(actual.left.right.value == 4);
        assertTrue(actual.right.value == 11);
        assertTrue(actual.right.left.value == 7);
        assertTrue(actual.right.right.value == 6);
    }

    @Test
    public void TestCase2() {
        MergeBinaryTrees.BinaryTree tree1 = createBinaryTree1();
        MergeBinaryTrees.BinaryTree tree2 = createBinaryTree2();

        MergeBinaryTrees.BinaryTree actual = new MergeBinaryTrees().mergeBinaryTrees_Algo2(tree1, tree2);

        assertTrue(actual.value == 2);
        assertTrue(actual.left.value == 8);
        assertTrue(actual.left.left.value == 9);
        assertTrue(actual.left.right.value == 4);
        assertTrue(actual.right.value == 11);
        assertTrue(actual.right.left.value == 7);
        assertTrue(actual.right.right.value == 6);
    }

    private MergeBinaryTrees.BinaryTree createBinaryTree2() {
        MergeBinaryTrees.BinaryTree tree2 = new MergeBinaryTrees.BinaryTree(1);
        tree2.left = new MergeBinaryTrees.BinaryTree(5);
        tree2.left.left = new MergeBinaryTrees.BinaryTree(2);
        tree2.right = new MergeBinaryTrees.BinaryTree(9);
        tree2.right.left = new MergeBinaryTrees.BinaryTree(7);
        tree2.right.right = new MergeBinaryTrees.BinaryTree(6);
        return tree2;
    }

    private MergeBinaryTrees.BinaryTree createBinaryTree1() {
        MergeBinaryTrees.BinaryTree tree1 = new MergeBinaryTrees.BinaryTree(1);
        tree1.left = new MergeBinaryTrees.BinaryTree(3);
        tree1.left.left = new MergeBinaryTrees.BinaryTree(7);
        tree1.left.right = new MergeBinaryTrees.BinaryTree(4);
        tree1.right = new MergeBinaryTrees.BinaryTree(2);
        return tree1;
    }

}