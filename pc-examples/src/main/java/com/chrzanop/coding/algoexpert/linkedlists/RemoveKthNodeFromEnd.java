package com.chrzanop.coding.algoexpert.linkedlists;

public class RemoveKthNodeFromEnd {

    // O(n) time | O(1) space
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList first = head;
        LinkedList second = head;
        int counter = 1;
        while (counter <= k) {
            second = second.next;
            counter += 1;
        }
        if (second == null) {
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }


}
