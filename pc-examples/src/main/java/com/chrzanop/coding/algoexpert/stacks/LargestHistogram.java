package com.chrzanop.coding.algoexpert.stacks;

import java.util.Stack;

public class LargestHistogram {

    public static int maxArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            // Use 0 as a virtual bar at the end to flush out remaining bars in the stack
            int currentHeight = (i == n) ? 0 : heights[i];

            // Maintain a strictly increasing stack
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];

                // If stack is empty, it means this bar was the shortest so far,
                // so the width extends from the start (index 0) to i.
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // Example with a '0' bar inside
        int[] heights = {2, 1, 5, 6, 0, 2, 3};
        System.out.println("Max Rectangle Area: " + maxArea(heights)); // Output: 10 (from heights 5 and 6)
    }
}
