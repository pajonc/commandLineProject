package com.chrzanop.coding.algoexpert.binarytrees;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IterativeInOrderTraversalAlgoTest {

    List<Integer> testArray = new ArrayList<>();

    Void testCallback(IterativeInOrderTraversalAlgo.BinaryTree node) {
        if(node == null) {
            return null;
        }
        System.out.println("Callback "+node.value);
        testArray.add(node.value);
        return null;
    }

    @Test
    public void TestCase1() {
        var root = new IterativeInOrderTraversalAlgo.BinaryTree(1);
        root.left = new IterativeInOrderTraversalAlgo.BinaryTree(2, root);
        root.left.left = new IterativeInOrderTraversalAlgo.BinaryTree(4, root.left);
        root.left.left.right = new IterativeInOrderTraversalAlgo.BinaryTree(9, root.left.left);
        root.right = new IterativeInOrderTraversalAlgo.BinaryTree(3, root);
        root.right.left = new IterativeInOrderTraversalAlgo.BinaryTree(6, root.right);
        root.right.right = new IterativeInOrderTraversalAlgo.BinaryTree(7, root.right);

        this.testArray.clear();
        IterativeInOrderTraversalAlgo.iterativeInOrderTraversal(root, this::testCallback);
        List<Integer> expected = Arrays.asList(new Integer[] {4, 9, 2, 1, 6, 3, 7});
        assertTrue( expected.equals(this.testArray));
    }

}