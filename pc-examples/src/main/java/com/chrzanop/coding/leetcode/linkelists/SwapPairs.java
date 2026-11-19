package com.chrzanop.coding.leetcode.linkelists;

public class SwapPairs {

    public static void main(String[] args) {

        ListNode head = generateLinkedList();

        System.out.println(head.val);

        ListNode swapPairs = swapPairs(head);

        System.out.println(swapPairs.val);

        ListNode head2 = generateLinkedList();
        ListNode swapPairs2 = swapPairs2(head2);
        System.out.println(swapPairs2.val);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode topHead = head;
        ListNode currentHead = head;
        ListNode prevNode = null;

        boolean modifyTopHead = true;

        while (currentHead != null && currentHead.next != null) {
            if (modifyTopHead) {
                topHead = currentHead.next;
                modifyTopHead = false;
            }

            ListNode nextNode = currentHead.next;
            ListNode nextHead = nextNode.next;

            currentHead.next = nextHead;
            nextNode.next = currentHead;
            if(prevNode == null) {
                prevNode = currentHead;
            } else {
                prevNode.next = nextNode;
                prevNode = currentHead;
            }

            currentHead = nextHead;
        }

        return topHead;
    }

    public static ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swap the pair
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move prev forward by two nodes
            prev = first;
        }

        return dummy.next;
    }


    static class ListNode {
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

    private static ListNode generateLinkedList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        return head;
    }
}
