package com.chrzanop.coding.algoexpert.stacks;

import java.util.ArrayList;

public class SortStack {

    //O(n^2) time | O(n) space - where n is the length of the stack
    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {

        if (stack.isEmpty()) {
            return stack;
        }

        Integer top = stack.remove(stack.size() - 1);

        sortStack(stack);

        insertInSortedOrder(stack, top);

        return stack;
    }

    private void insertInSortedOrder(ArrayList<Integer> stack, Integer value) {
        if (stack.isEmpty() || stack.get(stack.size() - 1) < value) {
            stack.add(value);
            return;
        }

        Integer top = stack.remove(stack.size() - 1);

        insertInSortedOrder(stack, value);

        stack.add(top);
    }


}
