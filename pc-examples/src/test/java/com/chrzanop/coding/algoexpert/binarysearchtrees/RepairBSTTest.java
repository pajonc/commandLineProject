package com.chrzanop.coding.algoexpert.binarysearchtrees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RepairBSTTest {

    /**


             2
         1      3
       4          0

     */

    @Test
    public void TestCase1() {
        RepairBST.BST tree = new RepairBST.BST(2);
        tree.left = new RepairBST.BST(1);
        tree.right = new RepairBST.BST(3);
        tree.left.left = new RepairBST.BST(4);
        tree.right.right = new RepairBST.BST(0);
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> actual = inOrderTraverse(new RepairBST().repairBst(tree), new ArrayList<Integer>());
        assertEquals(actual, expected);
    }

    private static List<Integer> inOrderTraverse(RepairBST.BST tree, List<Integer> array) {
        if (tree.left != null) {
            inOrderTraverse(tree.left, array);
        }
        array.add(tree.value);
        if (tree.right != null) {
            inOrderTraverse(tree.right, array);
        }
        return array;
    }

}