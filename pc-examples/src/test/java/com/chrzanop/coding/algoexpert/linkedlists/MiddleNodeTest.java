package com.chrzanop.coding.algoexpert.linkedlists;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MiddleNodeTest {
    @Test
    public void TestCase1() {
        MiddleNode.LinkedList linkedList = new MiddleNode.LinkedList(0);
        linkedList.next = new MiddleNode.LinkedList(1);
        MiddleNode.LinkedList expected = new MiddleNode.LinkedList(2);
        linkedList.next.next = expected;
        expected.next = new MiddleNode.LinkedList(3);
        MiddleNode middleNode = new MiddleNode();
        MiddleNode.LinkedList actual1 = middleNode.middleNode(linkedList);
        MiddleNode.LinkedList actual2 = middleNode.middleNode_Algo2(linkedList);
        assertTrue(expected.equals(actual2));
        assertTrue(expected.equals(actual1));
    }
    

}