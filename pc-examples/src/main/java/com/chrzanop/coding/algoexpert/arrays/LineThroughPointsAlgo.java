package com.chrzanop.coding.algoexpert.arrays;

import java.util.HashMap;
import java.util.Map;

public class LineThroughPointsAlgo {

    // O(n^2) time | O(n) space - where n is the number of points
    public static int lineThroughPoints(int[][] points) {
        int maxNumberOfPointsOnLine = 1;

        for (int idx1 = 0; idx1 < points.length; idx1++) {
            int[] p1 = points[idx1];
            Map<String, Integer> slopes = new HashMap<>();

            for (int idx2 = idx1 + 1; idx2 < points.length; idx2++) {
                int[] p2 = points[idx2];
                int[] slopeOfLineBetweenPoints = getSlopeOfLineBetweenPoints(p1, p2);
                int rise = slopeOfLineBetweenPoints[0];
                int run = slopeOfLineBetweenPoints[1];

                String slopeKey = createHashableKeyForRational(rise, run);
                if (!slopes.containsKey(slopeKey)) {
                    slopes.put(slopeKey, 1);
                }
                slopes.put(slopeKey, slopes.get(slopeKey) + 1);
            }

            int currentMaxNumberOfPointsOnLine = maxSlope(slopes);
            maxNumberOfPointsOnLine = Math.max(maxNumberOfPointsOnLine, currentMaxNumberOfPointsOnLine);

        }
        return maxNumberOfPointsOnLine;
    }

    private static int[] getSlopeOfLineBetweenPoints(int[] p1, int[] p2) {
        int p1x = p1[0];
        int p1y = p1[1];
        int p2x = p2[0];
        int p2y = p2[1];

        int[] slope = new int[]{1, 0}; // slope of a vertical line

        if (p1x != p2x) {
            int xDiff = p1x - p2x;
            int yDiff = p1y - p2y;
            int gcd = getGreatestCommonDivisor(Math.abs(xDiff), Math.abs(yDiff));
            xDiff = xDiff / gcd;
            yDiff = yDiff / gcd;
            if (xDiff < 0) {
                xDiff *= -1;
                yDiff *= -1;
            }
            slope = new int[]{yDiff, xDiff};
        }
        return slope;
    }

    private static String createHashableKeyForRational(int numerator, int denominator) {
        return String.valueOf(numerator) + ":" + String.valueOf(denominator);
    }

    private static int maxSlope(Map<String, Integer> slopes) {
        int currentMax = 0;
        for (Map.Entry<String, Integer> slope : slopes.entrySet()) {
            currentMax = Math.max(slope.getValue(), currentMax);
        }
        return currentMax;
    }

    private static int getGreatestCommonDivisor(int num1, int num2) {
        int a = num1;
        int b = num2;
        while (true) {
            if (a == 0) {
                return b;
            }
            if (b == 0) {
                return a;
            }
            int temp = a;
            a = b;
            b = temp % b;
        }
    }

}
