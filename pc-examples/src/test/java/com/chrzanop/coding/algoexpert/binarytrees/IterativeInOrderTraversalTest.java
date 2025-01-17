package com.chrzanop.coding.algoexpert.binarytrees;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class IterativeInOrderTraversalTest {

    List<Integer> testArray = new ArrayList<>();

    Void testCallback(IterativeInOrderTraversal.BinaryTree node) {
        if(node == null) {
            return null;
        }
        System.out.println("Callback "+node.value);
        testArray.add(node.value);
        return null;
    }

    @Test
    public void TestCase1() {
        var root = new IterativeInOrderTraversal.BinaryTree(1);
        root.left = new IterativeInOrderTraversal.BinaryTree(2, root);
        root.left.left = new IterativeInOrderTraversal.BinaryTree(4, root.left);
        root.left.left.right = new IterativeInOrderTraversal.BinaryTree(9, root.left.left);
        root.right = new IterativeInOrderTraversal.BinaryTree(3, root);
        root.right.left = new IterativeInOrderTraversal.BinaryTree(6, root.right);
        root.right.right = new IterativeInOrderTraversal.BinaryTree(7, root.right);

        this.testArray.clear();
        IterativeInOrderTraversal.iterativeInOrderTraversal(root, this::testCallback);
        List<Integer> expected = Arrays.asList(new Integer[] {4, 9, 2, 1, 6, 3, 7});
        assertTrue( expected.equals(this.testArray));
    }


}