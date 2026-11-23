package com.chrzanop.coding.leetcode.linkelists;

public class ReverseBetween {

    public static void main(String[] args) {
        ReverseBetween rb = new ReverseBetween();
        ListNode head = rb.createLinkedList(1, 2, 3, 4, 5);
        printList(head);

        ListNode result = rb.reverseBetweenAI(head, 2, 4);
        printList(result);

        ListNode head2 = rb.createLinkedList(3,5);
        printList(head2);

        ListNode result2 = rb.reverseBetweenAI(head2, 1, 2);
        printList(result2);
    }

    private ListNode createLinkedList(int... values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode root = new ListNode(0, head);
        ListNode currentHead = root;
        ListNode currentNode = currentHead.next;

        while (currentNode.next != null && currentNode.next.val <= right) {
            if(currentNode.val < left) {
                currentHead = currentNode;
                currentNode = currentNode.next;
            }

            ListNode currentNodeNext = currentNode.next;
            ListNode currentNodeNextNext = currentNode.next.next;

            currentNodeNext.next = currentHead.next;
            currentHead.next = currentNodeNext;
            currentNode.next = currentNodeNextNext;

        }

        return root.next;

    }

    public ListNode reverseBetweenAI(ListNode head, int left, int right) {
        // A dummy node handles the case where left == 1 (the head changes).
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        // Move prev to the node just before position `left`.
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // `curr` is the first node in the segment to reverse.
        // Repeatedly pull the node after `curr` to the front of the segment.
        ListNode curr = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode nxt = curr.next;
            curr.next = nxt.next;
            nxt.next = prev.next;
            prev.next = nxt;
        }

        return dummy.next;
    }

     class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
