package com.chrzanop.coding.algoexpert.binarytrees;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class FindNodesDistanceKTest {


    @Test
    public void TestCase1() {
        FindNodesDistanceK.BinaryTree root = new FindNodesDistanceK.BinaryTree(1);
        root.left = new FindNodesDistanceK.BinaryTree(2);
        root.right = new FindNodesDistanceK.BinaryTree(3);
        root.left.left = new FindNodesDistanceK.BinaryTree(4);
        root.left.right = new FindNodesDistanceK.BinaryTree(5);
        root.right.right = new FindNodesDistanceK.BinaryTree(6);
        root.right.right.left = new FindNodesDistanceK.BinaryTree(7);
        root.right.right.right = new FindNodesDistanceK.BinaryTree(8);
        int target = 3;
        int k = 2;
        ArrayList expected = new ArrayList<Integer>(Arrays.asList(2, 7, 8));
        ArrayList actual = new FindNodesDistanceK().findNodesDistanceK(root, target, k);
        Collections.sort(actual);
        assertTrue(expected.equals(actual));
    }

}