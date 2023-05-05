package com.chrzanop.coding.algoexpert.linkedlists;

public class MiddleNode {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList middleNode(LinkedList linkedList) {
        int counter = 0;
        LinkedList current = linkedList;
        while (current != null) {
            current = current.next;
            counter++;
        }
        LinkedList middleNode = linkedList;
        int middle = counter / 2;
        while (middle > 0) {
            middleNode = middleNode.next;
            middle--;
        }
        return middleNode;
    }

    // O(n) time | O(1) time
    public LinkedList middleNode_Algo2(LinkedList linkedList) {
        LinkedList fastNode = linkedList;
        LinkedList slowNode = linkedList;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        return slowNode;
    }
}
