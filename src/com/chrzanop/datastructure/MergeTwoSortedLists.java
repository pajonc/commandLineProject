package com.chrzanop.datastructure;


public class MergeTwoSortedLists {

    public static void main(String[] args) {

        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(4);
        l1_1.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2_1 = new ListNode(1);
        ListNode l2_2 = new ListNode(3);
        ListNode l2_3 = new ListNode(4);
        l2_1.next = l2_2;
        l2_2.next = l2_3;

        System.out.println(mergeTwoLists(l1_1, l2_1));

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode tempNode = new ListNode(0);
        ListNode currNode = tempNode;


        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                currNode.next = l1;
                l1 = l1.next;
            } else {
                currNode.next = l2;
                l2 = l2.next;
            }

            currNode = currNode.next;
        }

        if (l1 != null) {
            currNode.next = l1;
            l1 = l1.next;

        }

        if (l2 != null) {
            currNode.next = l2;
            l2 = l2.next;
        }

        return tempNode.next;

    }
}


