package com.chrzanop.coding.algoexpert.binarysearchtrees;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateThreeNodesTest {

    @Test
    public void TestCase1() {
        ValidateThreeNodes.BST root = new ValidateThreeNodes.BST(5);
        root.left = new ValidateThreeNodes.BST(2);
        root.right = new ValidateThreeNodes.BST(7);
        root.left.left = new ValidateThreeNodes.BST(1);
        root.left.right = new ValidateThreeNodes.BST(4);
        root.right.left = new ValidateThreeNodes.BST(6);
        root.right.right = new ValidateThreeNodes.BST(8);
        root.left.left.left = new ValidateThreeNodes.BST(0);
        root.left.right.left = new ValidateThreeNodes.BST(3);

        ValidateThreeNodes.BST nodeOne = root;
        ValidateThreeNodes.BST nodeTwo = root.left;
        ValidateThreeNodes.BST nodeThree = root.left.right.left;
        boolean expected = true;
        boolean actual = new ValidateThreeNodes().validateThreeNodes_Mine(nodeOne, nodeTwo, nodeThree);
        boolean actual2 = new ValidateThreeNodes().validateThreeNodes(nodeOne, nodeTwo, nodeThree);
        assertTrue(expected == actual);
        assertTrue(expected == actual2);
    }

    /**

     {
     "tree": {
     "nodes": [
     {"id": "1", "left": null, "right": null, "value": 1},
     {"id": "2", "left": "1", "right": null, "value": 2},
     {"id": "3", "left": "2", "right": null, "value": 3}
     ],
     "root": "3"
     },
     "nodeOne": "1",
     "nodeTwo": "2",
     "nodeThree": "3"
     }

     */

    @Test
    public void TestCase2() {
        ValidateThreeNodes.BST root = new ValidateThreeNodes.BST(3);
        root.left = new ValidateThreeNodes.BST(2);
        root.right = null;
        root.left.left = new ValidateThreeNodes.BST(1);

        ValidateThreeNodes.BST nodeOne = root.left.left;
        ValidateThreeNodes.BST nodeTwo = root.left;
        ValidateThreeNodes.BST nodeThree = root;
        boolean expected = true;
        boolean actual = new ValidateThreeNodes().validateThreeNodes_Mine(nodeOne, nodeTwo, nodeThree);
//        boolean actual2 = new ValidateThreeNodes().validateThreeNodes(nodeOne, nodeTwo, nodeThree);
        assertTrue(expected == actual);
//        assertTrue(expected == actual2);
    }

}