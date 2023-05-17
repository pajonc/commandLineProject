package com.chrzanop.coding.algoexpert.stacks;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElement {


    // O(n) time | O(n) space - where n is the length of the array
    public int[] nextGreaterElement_Algo1(int[] array) {
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

    // O(n) time | O(n) space - where n is the length of the array
    // reverse order algorithm
    public int[] nextGreaterElement_Algo2(int[] array) {
        int[] result = new int[array.length];
        Arrays.fill(result, -1);

        Deque<Integer> stack = new LinkedList<>();

        for (int i = 2 * array.length- 1; i>=0; i--) {
            int circularIdx = i % array.length;
            while (stack.size()>0) {
                if (stack.peek() <= array[circularIdx]) {
                    stack.pop();
                } else {
                    result[circularIdx] = stack.peek();
                    break;
                }
            }
            stack.push(array[circularIdx]);
        }

        return result;
    }

    // O(n^2) time | O(1) space - where n is the length of the array
    public int[] nextGreaterElementComplex(int[] array) {
        int[] result = new int[array.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < array.length; i++) {
            int j=1;
            int currentElement = array[i];
            while(j<array.length) {
                int k = (i + j) % array.length;
                if(currentElement<array[k]) {
                    result[i] = array[k];
                    break;
                }
                j++;
            }
        }
        return result;
    }


}
