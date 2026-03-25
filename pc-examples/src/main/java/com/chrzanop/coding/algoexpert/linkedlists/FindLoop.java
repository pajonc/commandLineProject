package com.chrzanop.coding.algoexpert.linkedlists;

public class FindLoop {

    // O(n) time | O(1) space
    public static LinkedList findLoop(LinkedList head) {

        LinkedList firstPointer = head.next;
        LinkedList secondPointer = head.next.next;

        while(firstPointer!=secondPointer) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;
        }

        secondPointer = head;

        while (firstPointer!=secondPointer) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        return firstPointer;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
