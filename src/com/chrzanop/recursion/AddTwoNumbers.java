package com.chrzanop.recursion;

public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode l1_1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        ListNode l1_3 = new ListNode(3);
        l1_1.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2_1 = new ListNode(5);
        ListNode l2_2 = new ListNode(6);
        ListNode l2_3 = new ListNode(4);
        l2_1.next = l2_2;
        l2_2.next = l2_3;

        ListNode node = addTwoNumbers(l1_1, l2_1);
        System.out.println(node);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyListNode = new ListNode(0);
        ListNode l3 = dummyListNode;

        int carry = 0;

        while (l1 != null || l2 != null) {

            int l1_val = l1 != null ? l1.val : 0;
            int l2_val = l2 != null ? l2.val : 0;

            int current_sum = l1_val + l2_val + carry;
            carry = current_sum / 10;
            int lastDigit = current_sum % 10;

            ListNode new_node = new ListNode(lastDigit);
            l3.next = new_node;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            l3 = l3.next;

        }

        if (carry > 0) {
            ListNode new_node = new ListNode(carry);
            l3.next = new_node;
            l3 = l3.next;
        }

        return dummyListNode.next;
    }


}
