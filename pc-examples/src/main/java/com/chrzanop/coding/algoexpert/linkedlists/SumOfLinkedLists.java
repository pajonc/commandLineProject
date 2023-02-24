package com.chrzanop.coding.algoexpert.linkedlists;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class SumOfLinkedLists {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // O(max(n,m)) time | O(max(n,m)) space - where n is the length of the
    // first Linked List and m is the length of the second Linked List
    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // This variable will store a dummy node whose .next
        // attribute will point to the head of our new LL.
        LinkedList newLinkedListHeaderPointer = new LinkedList(0);
        LinkedList currentNode = newLinkedListHeaderPointer;
        int carry = 0;

        LinkedList nodeOne = linkedListOne;
        LinkedList nodeTwo = linkedListTwo;
        while (nodeOne != null || nodeTwo != null || carry != 0) {
            int valueOne = nodeOne != null ? nodeOne.value : 0;
            int valueTwo = nodeTwo != null ? nodeTwo.value : 0;
            int sumOfValues = valueOne + valueTwo + carry;

            int newValue = sumOfValues % 10;
            LinkedList newNode = new LinkedList(newValue);
            currentNode.next = newNode;
            currentNode = newNode;

            carry = sumOfValues / 10;
            nodeOne = nodeOne !=null ? nodeOne.next : null;
            nodeTwo = nodeTwo != null ? nodeTwo.next : null;
        }
        return newLinkedListHeaderPointer.next;
    }


    @Test
    public void TestCase1() {
        LinkedList ll1 = addMany(new LinkedList(2), new int[]{4, 7, 1});
        LinkedList ll2 = addMany(new LinkedList(9), new int[]{4, 5});
        LinkedList expected = addMany(new LinkedList(1), new int[]{9, 2, 2});
        LinkedList actual = sumOfLinkedLists(ll1, ll2);
        assertTrue(getNodesInArray(expected).equals(getNodesInArray(actual)));
    }

    public LinkedList addMany(LinkedList linkedList, int[] values) {
        LinkedList current = linkedList;
        while (current.next != null) {
            current = current.next;
        }
        for (int value : values) {
            current.next = new LinkedList(value);
            current = current.next;
        }
        return linkedList;
    }

    public ArrayList<Integer> getNodesInArray(LinkedList linkedList) {
        ArrayList<Integer> nodeValues = new ArrayList<Integer>();
        LinkedList current = linkedList;
        while (current != null) {
            nodeValues.add(current.value);
            current = current.next;
        }
        return nodeValues;
    }

}
