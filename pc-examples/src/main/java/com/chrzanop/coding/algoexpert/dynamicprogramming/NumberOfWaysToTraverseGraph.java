package com.chrzanop.coding.algoexpert.dynamicprogramming;

public class NumberOfWaysToTraverseGraph {

    // O(2^n+m) time | O(h) space where h is the graph height
    public static int numberOfWaysToTraverseGraph(int width, int height) {
        // Write your code here.
        return numWays(width - 1, height - 1, 0, 0);
    }

    public static int numberOfWaysToTraverseGraphSecond(int width, int height) {
        return numWaysSecond(width, height);
    }

    private static int numWays(int width, int height, int coordinateX, int coordinateY) {
        if (width < 1 && height < 1) {
            return 0;
        }
        if (coordinateX > width || coordinateY > height) {
            return 0;
        }

        if (coordinateX == width && coordinateY == height) {
            return 1;
        }

        int rightMove = numWays(width, height, coordinateX + 1, coordinateY);
        int downMove = numWays(width, height, coordinateX, coordinateY + 1);
        int numWays = rightMove + downMove;

        return numWays;
    }

    private static int numWaysSecond(int width, int height) {

        if (width == 1 || height == 1)
            return 1;

        int rightMove = numWaysSecond(width -1, height);
        int downMove = numWaysSecond(width, height -1);
        int numWays = rightMove + downMove;

        return numWays;
    }
}
