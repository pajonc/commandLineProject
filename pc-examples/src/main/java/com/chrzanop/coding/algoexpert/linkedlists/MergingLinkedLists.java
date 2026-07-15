package com.chrzanop.coding.algoexpert.linkedlists;

import java.util.HashSet;
import java.util.Set;

public class MergingLinkedLists {


    // This is an input class. Do not edit.
    public static class LinkedList {
        public int val;
        public LinkedList next;

        public LinkedList(int value) {
            this.val = value;
            this.next = null;
        }
    }

//    public LinkedList mergingLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
//        Set<LinkedList> listOne = new HashSet<>();
//        LinkedList currentNodeOne = linkedListOne;
//        while(currentNodeOne != null) {
//            listOne.add(currentNodeOne);
//            currentNodeOne = currentNodeOne.next;
//        }
//        LinkedList currentNodeTwo = linkedListTwo;
//        while(currentNodeTwo != null) {
//            if(listOne.contains(currentNodeTwo)) {
//                return currentNodeTwo;
//            }
//            currentNodeTwo = currentNodeTwo.next;
//        }
//        return null;
//    }

    public LinkedList mergingLinkedLists(LinkedList list1, LinkedList list2) {
        // Create a sentinel/dummy node to act as the head of the new list
        LinkedList dummy = new LinkedList(-1);
        LinkedList current = dummy;

        // Traverse both lists while they both have elements
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            // Move our building pointer forward
            current = current.next;
        }

        // If one list is exhausted, link the rest of the other list
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Return the actual head of the merged list
        return dummy.next;
    }
    
}
