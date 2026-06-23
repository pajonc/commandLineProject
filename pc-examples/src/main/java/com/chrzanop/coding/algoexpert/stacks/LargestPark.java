package com.chrzanop.coding.algoexpert.stacks;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LargestPark {

    //O(n) time | O(n) space
    public int largestPark(boolean[][] land) {
        int rows = land.length;
        int cols = land[0].length;
        int maxArea = 0;

        int[] heights = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean isLand = land[i][j];
                heights[j] = isLand ? 0 : heights[j] + 1;
            }
            maxArea = Math.max(maxArea, largestRectangle(heights));
        }

        return maxArea;
    }

    private int largestRectangle(int[] heights) {

        int largestRectangle = 0;

        Deque<Integer> stack = new LinkedList<>();

        for (int columnIndex = 0; columnIndex <= heights.length; columnIndex++) {

            int currentHeight = columnIndex == heights.length ? 0 : heights[columnIndex];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? columnIndex : columnIndex - stack.peek() - 1;
                largestRectangle = Math.max(largestRectangle, height * width);
            }
            stack.push(columnIndex);
        }

        return largestRectangle;
    }
}
