package com.chrzanop.coding.algoexpert.dynamicprogramming;

public class WaterArea {

    // O(n) time | O(n) space - where n is the length of the input array
    public static int waterArea(int[] heights) {

        int[] leftMax = new int[heights.length];
        int[] rightMax = new int[heights.length];
        int currentMaxLeft = 0;
        for (int i = 1; i < heights.length; i++) {
            if (currentMaxLeft < heights[i - 1]) {
                leftMax[i] = heights[i - 1];
            } else {
                leftMax[i] = currentMaxLeft;
            }
            currentMaxLeft = leftMax[i];
        }

        int currentMaxRight = 0;
        for (int i = heights.length - 2; i >= 0; i--) {
            if (currentMaxRight < heights[i + 1]) {
                rightMax[i] = heights[i + 1];
            } else {
                rightMax[i] = currentMaxRight;
            }
            currentMaxRight = rightMax[i];
        }

        int[] result = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            int minPillar = Math.min(leftMax[i], rightMax[i]);
            if (minPillar > 0 && minPillar - heights[i] > 0) {
                result[i] = minPillar - heights[i];
            }
        }

        int area = 0;
        for (int i = 0; i < result.length; i++) {
            area += result[i];
        }

        return area;
    }

    // O(n) time | O(n) space - where n is the length of the input array
    public static int waterAreaAlgo1(int[] heights) {
        int maxes[] = new int[heights.length];
        int leftMax = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            maxes[i] = leftMax;
            leftMax = Math.max(leftMax, height);
        }
        int rightMax = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            int height = heights[i];
            int minHeight = Math.min(rightMax, maxes[i]);
            if (height < minHeight) {
                maxes[i] = minHeight - height;
            } else {
                maxes[i] = 0;
            }
            rightMax = Math.max(height, rightMax);
        }
        int total = 0;
        for (int i = 0; i < heights.length; i++) {
            total += maxes[i];
        }
        return total;
    }

}
