package com.chrzanop.coding.algoexpert.linkedlists;

public class ReverseLinkedList {


    public static LinkedList reverseListAI(LinkedList head) {

        LinkedList prev = null;
        LinkedList current = head;
        LinkedList next = null;

        while (current != null) {
            next = current.next;    // 1. Save the next node
            current.next = prev;    // 2. Reverse the pointer
            prev = current;         // 3. Move 'prev' one step forward
            current = next;         // 4. Move 'current' one step forward
        }

        // At the end, 'prev' will be pointing to the new head of the reversed list
        return prev;
    }

    // Result: prev -> 1 -> null  , current,next -> 2 -> 3
    // Result: prev -> 2 -> 1 -> null  , current,next -> 3
    // Result: prev -> 3 -> 2 -> 1 -> null  , current,next -> null



    public static LinkedList reverseListWithDummy(LinkedList head) {
        // 1. Create the dummy node. Its value doesn't matter.
        LinkedList dummy = new LinkedList(-1);

        LinkedList current = head;
        while (current != null) {
            LinkedList nextTemp = current.next; // Temporary store the remaining list

            // Insert current node right after dummy
            current.next = dummy.next;
            dummy.next = current;

            // Move to the next node in the original list
            current = nextTemp;
        }

        // The reversed list starts right after the dummy node
        return dummy.next;
    }

//    Result: dummy -> 1 -> null
//    Result: dummy -> 2 -> 1 -> null
//            dummy -> 3 -> 2 -> 1 -> null


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
