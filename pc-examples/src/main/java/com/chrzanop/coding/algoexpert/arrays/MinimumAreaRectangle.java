package com.chrzanop.coding.algoexpert.arrays;

import java.util.HashSet;
import java.util.Set;

public class MinimumAreaRectangle {

    // O(n^2) time | O(n) space - where n is the number of points
    public int minimumAreaRectangle(int[][] points) {

        Set<String> combinationOfXYPoints = new HashSet<>();
        int minArea = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            combinationOfXYPoints.add(points[i][0] + "|" + points[i][1]);
        }

        for (int i = 0; i < points.length; i++) {
            int[] pointA = points[i];
            for (int j = 1; j < i; j++) {
                if (points[j][0] == pointA[0] || points[j][1] == pointA[1]) continue;
                int[] pointC = points[j];

                String coordinateB = pointA[0] + "|" + pointC[1];
                String coordinateD = pointA[1] + "|" + pointC[0];

                if (combinationOfXYPoints.contains(coordinateB) && combinationOfXYPoints.contains(coordinateD)) {
                    int rectangleArea = Math.abs(pointA[0] - pointC[0]) * Math.abs(pointA[1] - pointC[1]);
                    minArea = Math.min(minArea, rectangleArea);
                }
            }
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }

    // O(n^2) time | O(n) space - where n is the number of points
    public int minimumAreaRectangleAlgo(int[][] points) {
        HashSet<String> pointSet = createPointSet(points);
        int miminumAreaFound = Integer.MAX_VALUE;

        for (int currentIdx = 0; currentIdx < points.length; currentIdx++) {
            int p2x = points[currentIdx][0];
            int p2y = points[currentIdx][1];

            for (int previousIdx = 0; previousIdx < currentIdx; previousIdx++) {
                int p1x = points[previousIdx][0];
                int p1y = points[previousIdx][1];

                boolean pointsShareValue = p1x == p2x || p1y == p2y;
                if (pointsShareValue) continue;

                boolean point1OnOppositeDiagonalExists = pointSet.contains(convertPointToString(p1x, p2y));
                boolean point2OnOppositeDiagonalExists = pointSet.contains(convertPointToString(p2x, p1y));
                boolean oppositeDiagonalExists = point1OnOppositeDiagonalExists && point2OnOppositeDiagonalExists;

                if (oppositeDiagonalExists) {
                    int currentArea = Math.abs(p2x - p1x) * Math.abs(p2y - p1y);
                    miminumAreaFound = Math.min(miminumAreaFound, currentArea);
                }
            }
        }
        return (miminumAreaFound != Integer.MAX_VALUE) ? miminumAreaFound : 0;
    }

    private HashSet<String> createPointSet(int[][] points) {
        HashSet<String> pointSet = new HashSet<>();
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            pointSet.add(convertPointToString(x, y));
        }
        return pointSet;
    }

    private String convertPointToString(int x, int y) {
        return String.valueOf(x) + ":" + String.valueOf(y);
    }

}
