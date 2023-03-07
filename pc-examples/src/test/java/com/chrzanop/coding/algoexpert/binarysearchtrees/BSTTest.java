package com.chrzanop.coding.algoexpert.binarysearchtrees;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BSTTest {

    @Test
    public void TestCase1() {
        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);

        root.insert(12);
        assertTrue(root.right.left.left.value == 12);

        root.remove(10);
        assertTrue(root.contains(10) == false);
        assertTrue(root.containsR(12) == true);
        assertTrue(root.containsR(14) == true);


        assertTrue(root.contains(15));
        assertFalse(root.contains(16));

        root.remove(1);
        assertTrue(root.contains(1) == false);
    }

    @Test
    public void testCase2() {

        BST root = new BST(5);
        root.insert(15);

        root.remove(5);

        root.remove(15);
        root.remove(10);

    }


    @Test
    public void testCase3() {
        BST root = new BST(5);
        root.insert(6);
        root.insert(7);
        root.insert(9);

        root.remove(5);
        assertTrue(root.contains(5) == false);
    }

    @Test
    public void testCase4() {
        BST root = new BST(10);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.right = new BST(22);


        root.remove(10);
        assertTrue(root.contains(5) == false);
    }




}