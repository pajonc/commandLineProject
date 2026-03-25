package com.chrzanop.coding.algoexpert.linkedlists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindLoopTest {

    @Test
    public void TestCase1() {
        TestLinkedList test = new TestLinkedList(0);
        test.addMany(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        test.getNthNode(10).next = test.getNthNode(5);
        assertTrue(FindLoop.findLoop(test) == test.getNthNode(5));
    }

    class TestLinkedList extends FindLoop.LinkedList {
        public TestLinkedList(int value) {
            super(value);
        }

        public void addMany(int[] values) {
            FindLoop.LinkedList current = this;
            while (current.next != null) {
                current = current.next;
            }
            for (int value : values) {
                current.next = new FindLoop.LinkedList(value);
                current = current.next;
            }
        }

        public FindLoop.LinkedList getNthNode(int n) {
            int counter = 1;
            FindLoop.LinkedList current = this;
            while (counter < n) {
                current = current.next;
                counter++;
            }
            return current;
        }
    }

}