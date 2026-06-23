package com.chrzanop.tmp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MonotonicStackExample {

    public static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Initialize the result array with -1
        Arrays.fill(result, -1);

        // Deque is the recommended Stack implementation in Java
        // We store indices instead of values to easily map back to the result array
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // While stack is not empty AND the current element is strictly greater
            // than the element represented by the index at the top of the stack
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int poppedIndex = stack.pop();
                result[poppedIndex] = nums[i]; // Current element is the "next greater"
            }

            // Push the current index onto the stack
            stack.push(i);
        }

        return result;
    }


    public static int[] nextGreaterElement2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Initialize the result array with -1
        Arrays.fill(result, -1);

        // Deque is the recommended Stack implementation in Java
        // We store indices instead of values to easily map back to the result array
        Deque<Integer> stack = new ArrayDeque<>();

        for (int index = n-1; index >=0 ; index--) {
            // While stack is not empty AND the current element is strictly greater
            // than the element represented by the index at the top of the stack
            while (!stack.isEmpty()) {
                int currentValue = nums[index];
                int topStackValue = nums[stack.peek()];
                if(currentValue>=topStackValue) {
                    stack.pop();
                } else {
                    result[index] = topStackValue;
                    break;
                }
            }
            // Push the current index onto the stack
            stack.push(index);
        }

        return result;
    }




    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 25, 7, 8};
        int[] result = nextGreaterElement(nums);

        System.out.println("Input Array:  " + Arrays.toString(nums));
        System.out.println("Next Greater: " + Arrays.toString(result));

        System.out.println("---------");

        int[] nums2 = {2, 1, 2, 4, 3};
        int[] result2 = nextGreaterElement(nums2);

        System.out.println("Input Array 2:  " + Arrays.toString(nums2));
        System.out.println("Next Greater 2: " + Arrays.toString(result2));

        System.out.println("---------");

        int[] nums3 = {2, 1, 2, 4, 3};
        int[] result3 = nextGreaterElement2(nums3);

        System.out.println("Input Array 3:  " + Arrays.toString(nums3));
        System.out.println("Next Greater 3: " + Arrays.toString(result3));

        System.out.println("---------");

    }
}
