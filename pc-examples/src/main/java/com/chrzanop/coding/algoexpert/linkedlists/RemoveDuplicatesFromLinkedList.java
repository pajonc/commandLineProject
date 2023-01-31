package com.chrzanop.coding.algoexpert.linkedlists;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class RemoveDuplicatesFromLinkedList {


    public LinkedList addMany(LinkedList ll, List<Integer> values) {
        LinkedList current = ll;
        while (current.next != null) {
            current = current.next;
        }
        for (int value : values) {
            current.next = new LinkedList(value);
            current = current.next;
        }
        return ll;
    }

    public List<Integer> getNodesInArray(LinkedList ll) {
        List<Integer> nodes = new ArrayList<Integer>();
        LinkedList current = ll;
        while (current != null) {
            nodes.add(current.value);
            current = current.next;
        }
        return nodes;
    }

    @Test
    public void TestCase1() {
        LinkedList input = new LinkedList(1);
        addMany(input, new ArrayList<Integer>(Arrays.asList(1, 3, 4, 4, 4, 5, 6, 6)));
        List<Integer> expectedNodes = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 5, 6));
        LinkedList output = removeDuplicatesFromLinkedList(input);
        assertTrue(getNodesInArray(output).equals(expectedNodes));
    }


    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
    // O(n) time | O(1) space
    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {

        LinkedList current = linkedList;
        while (current != null ) {
            LinkedList nextDistinct = current.next;
            while (nextDistinct!=null && nextDistinct.value == current.value) {
                nextDistinct = nextDistinct.next;
            }
            current.next = nextDistinct;
            current =  nextDistinct;
        }

        return linkedList;
    }

    /*
       // O(n) time | O(n) space
        public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {

        LinkedList current = linkedList;
        LinkedList head = new LinkedList(current.value);
        LinkedList tempHead = head;
        while (current != null && current.next != null) {
            int currentValue = current.value;
            int nextValue = current.next.value;
            if (currentValue == nextValue) {
                current.next = current.next.next;
                continue;
            }
            current = current.next;
            tempHead.next = new LinkedList(current.value);
            tempHead = tempHead.next;
        }

        return head;
    }

     */
}


