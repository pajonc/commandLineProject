package com.chrzanop.coding.algoexpert.binarytrees;

import org.junit.Test;


import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeParentAppendTest {

    @Test
    public void TestCase1() {
        BinaryTreeParentAppend.BinaryTree root = new BinaryTreeParentAppend.BinaryTree(1);
        root.left = new BinaryTreeParentAppend.BinaryTree(2);
//        root.left.parent = root;
        root.right = new BinaryTreeParentAppend.BinaryTree(3);
//        root.right.parent = root;
        root.left.left = new BinaryTreeParentAppend.BinaryTree(4);
//        root.left.left.parent = root.left;
        root.left.right = new BinaryTreeParentAppend.BinaryTree(5);
//        root.left.right.parent = root.left;
        root.left.left.left = new BinaryTreeParentAppend.BinaryTree(6);
//        root.left.left.left.parent = root.left.left;
        BinaryTreeParentAppend.BinaryTree output = new BinaryTreeParentAppend().parentAppender(root);
        assertNotNull(output);

    }

}