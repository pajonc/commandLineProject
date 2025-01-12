package com.chrzanop.coding.algoexpert.binarytrees;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class FindNodesDistanceK_DFSTest {


    @Test
    public void TestCase1() {
        FindNodesDistanceK_DFS.BinaryTree root = new FindNodesDistanceK_DFS.BinaryTree(1);
        root.left = new FindNodesDistanceK_DFS.BinaryTree(2);
        root.right = new FindNodesDistanceK_DFS.BinaryTree(3);
        root.left.left = new FindNodesDistanceK_DFS.BinaryTree(4);
        root.left.right = new FindNodesDistanceK_DFS.BinaryTree(5);
        root.right.right = new FindNodesDistanceK_DFS.BinaryTree(6);
        root.right.right.left = new FindNodesDistanceK_DFS.BinaryTree(7);
        root.right.right.right = new FindNodesDistanceK_DFS.BinaryTree(8);
        int target = 3;
        int k = 2;
        ArrayList expected = new ArrayList<Integer>(Arrays.asList(2, 7, 8));
        ArrayList actual = new FindNodesDistanceK_DFS().findNodesDistanceK(root, target, k);
        Collections.sort(actual);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void TestCase2() {
        FindNodesDistanceK_DFS.BinaryTree root = new FindNodesDistanceK_DFS.BinaryTree(1);
        root.left = new FindNodesDistanceK_DFS.BinaryTree(2);
        root.right = new FindNodesDistanceK_DFS.BinaryTree(3);
        root.left.left = new FindNodesDistanceK_DFS.BinaryTree(4);
        root.left.right = new FindNodesDistanceK_DFS.BinaryTree(5);
        root.right.right = new FindNodesDistanceK_DFS.BinaryTree(6);
        root.right.right.left = new FindNodesDistanceK_DFS.BinaryTree(7);
        root.right.right.right = new FindNodesDistanceK_DFS.BinaryTree(8);
        int target = 7;
        int k = 3;
        ArrayList expected = new ArrayList<Integer>(Arrays.asList(1));
        ArrayList actual = new FindNodesDistanceK_DFS().findNodesDistanceK(root, target, k);
        System.out.println(actual);
        Collections.sort(actual);
        assertTrue(expected.equals(actual));
    }

}