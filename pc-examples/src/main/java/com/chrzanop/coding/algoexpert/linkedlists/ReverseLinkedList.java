package com.chrzanop.coding.algoexpert.linkedlists;

public class ReverseLinkedList {

    //O(n) time | O(1) space
    public static LinkedList reverseLinkedList(LinkedList head) {

        LinkedList current = head;
        while (current.next != null) {
            LinkedList tempHead = current.next;
            current.next = current.next.next;
            tempHead.next = head;
            head = tempHead;
        }

        return head;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
