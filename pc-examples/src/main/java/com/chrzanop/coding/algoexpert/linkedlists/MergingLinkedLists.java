package com.chrzanop.coding.algoexpert.linkedlists;

import java.util.HashSet;
import java.util.Set;

public class MergingLinkedLists {


    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList mergingLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        Set<LinkedList> listOne = new HashSet<>();
        LinkedList currentNodeOne = linkedListOne;
        while(currentNodeOne != null) {
            listOne.add(currentNodeOne);
            currentNodeOne = currentNodeOne.next;
        }
        LinkedList currentNodeTwo = linkedListTwo;
        while(currentNodeTwo != null) {
            if(listOne.contains(currentNodeTwo)) {
                return currentNodeTwo;
            }
            currentNodeTwo = currentNodeTwo.next;
        }
        return null;
    }
    
}
