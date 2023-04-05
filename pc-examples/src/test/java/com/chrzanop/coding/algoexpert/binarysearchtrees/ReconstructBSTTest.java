package com.chrzanop.coding.algoexpert.binarysearchtrees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReconstructBSTTest {

    public List<Integer> getDfsOrder(ReconstructBST.BST node, List<Integer> values) {
        values.add(node.value);
        if (node.left != null) {
            getDfsOrder(node.left, values);
        }
        if (node.right != null) {
            getDfsOrder(node.right, values);
        }
        return values;
    }

    @Test
    public void TestCase1() {
        List<Integer> preOrderTraversalValues =
                new ArrayList<Integer>(Arrays.asList(10, 4, 2, 1, 3, 17, 19, 18));
        ReconstructBST.BST tree = new ReconstructBST.BST(10);
        tree.left = new ReconstructBST.BST(4);
        tree.left.left = new ReconstructBST.BST(2);
        tree.left.left.left = new ReconstructBST.BST(1);
        tree.left.right = new ReconstructBST.BST(3);
        tree.right = new ReconstructBST.BST(17);
        tree.right.right = new ReconstructBST.BST(19);
        tree.right.right.left = new ReconstructBST.BST(18);
        List<Integer> expected = getDfsOrder(tree, new ArrayList<Integer>());
        ReconstructBST reconstructBST = new ReconstructBST();
        ReconstructBST.BST actual = reconstructBST.reconstructBstMineBasedOnSolution1((ArrayList<Integer>) preOrderTraversalValues);
        List<Integer> actualValues = getDfsOrder(actual, new ArrayList<Integer>());
        assertTrue(expected.equals(actualValues));

        ReconstructBST.BST actualAlgo1 = reconstructBST.reconstructBstAlgo1(preOrderTraversalValues);
        List<Integer> actualValuesAlgo1 = getDfsOrder(actualAlgo1, new ArrayList<Integer>());
        assertTrue(expected.equals(actualValuesAlgo1));

        ReconstructBST.BST actualAlgo2 = reconstructBST.reconstructBstAlgo2(preOrderTraversalValues);
        List<Integer> actualValuesAlgo2 = getDfsOrder(actualAlgo2, new ArrayList<Integer>());
        assertTrue(expected.equals(actualValuesAlgo2));
    }

}