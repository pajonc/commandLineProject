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

    // O(n*m) time | O(n*m) space - n width, m height of the graph (matrix)
    public static int numberOfWaysToTraverseGraphBottomUp(int width, int height) {
        int[][] numOfWays = new int[height][width];

        for (int heightIdx = 0; heightIdx < height; heightIdx++) {
            for (int widthIdx = 0; widthIdx < width; widthIdx++) {
                if(heightIdx == 0 || widthIdx == 0) {
                    numOfWays[heightIdx][widthIdx] = 1;
                } else {

                    int waysLeft = numOfWays[heightIdx][widthIdx - 1];
                    int waysUp = numOfWays[heightIdx - 1][widthIdx];
                    numOfWays[heightIdx][widthIdx]  = waysLeft + waysUp;
                }
            }
        }

        return numOfWays[height-1][width-1];
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
