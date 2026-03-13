package com.chrzanop.coding.algoexpert.arrays;

import java.util.HashSet;
import java.util.Set;

public class CountSquares {

    // O(n^2) | O(n) space

    public int countSquares(int[][] points) {

        Set<String> pointsSet = new HashSet<>();
        for (int[] point : points) {
            pointsSet.add(pointToString(point));
        }

        int counter = 0;
        for (int[] pointA : points) {
            for (int[] pointB : points) {
                if (pointA == pointB) {
                    continue;
                }

                double xMidPoint = (pointA[0] + pointB[0]) / 2.0;
                double yMidPoint = (pointA[1] + pointB[1]) / 2.0;

                double xDistance = pointA[0] - xMidPoint;
                double yDistance = pointA[1] - yMidPoint;

                double[] pointC = new double[]{xMidPoint + yDistance, yMidPoint - xDistance};
                double[] pointD = new double[]{xMidPoint - yDistance, yMidPoint + xDistance};

                if (pointsSet.contains(dbPointToString(pointC)) && pointsSet.contains(dbPointToString(pointD))) {
                    counter++;
                }
            }

        }


        return counter / 4;
    }

    private String pointToString(int[] point) {
        return point[0] + "," + point[1];
    }

    private String dbPointToString(double[] point) {
        if (point[0] % 1 == 0 && point[1] % 1 == 0) {
            return (int) point[0] + "," + (int) point[1];
        }
        return point[0] + "," + point[1];
    }


}
