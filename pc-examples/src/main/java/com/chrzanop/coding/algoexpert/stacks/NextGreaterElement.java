package com.chrzanop.coding.algoexpert.stacks;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElement {


    // O(n) time | O(n) space - where n is the length of the array
    public int[] nextGreaterElement(int[] array) {
        int[] result = new int[array.length];
        Arrays.fill(result, -1);

        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < 2 * array.length; i++) {
            int circularIdx = i % array.length;
            while (!stack.isEmpty()) {
                if (array[stack.peek()] < array[circularIdx]) {
                    int resultId = stack.pop();
                    result[resultId] = array[circularIdx];
                } else {
                    break;
                }
            }
            stack.push(circularIdx);
        }

        return result;
    }

}
