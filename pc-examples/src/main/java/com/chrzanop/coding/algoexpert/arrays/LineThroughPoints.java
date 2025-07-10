package com.chrzanop.coding.algoexpert.arrays;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;

public class LineThroughPoints {

    // O(n^2) time | O(n) space
    public int lineThroughPoints(int[][] points) {
        int maxNumberOfPoints = 1;


        for (int i = 0; i < points.length; i++) {
            int[] point1 = points[i];
            Map<String, Integer> slopesDictionary = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int[] point2 = points[j];
                String slope = getSlope(point1, point2);
                int currentMax = 1;
                if (!slopesDictionary.containsKey(slope)) {
                    currentMax += 1;
                    slopesDictionary.put(slope, currentMax);
                } else {
                    currentMax = slopesDictionary.get(slope) + 1;
                    slopesDictionary.put(slope, currentMax);
                }
                maxNumberOfPoints = Math.max(maxNumberOfPoints, currentMax);
            }
        }
        return maxNumberOfPoints;
    }

    private String getSlope(int[] point1, int[] point2) {
        int nominator = point2[1] - point1[1];
        int denominator = point2[0] - point1[0];
        if(denominator<0) {
            nominator = nominator * (-1);
            denominator = denominator * (-1);
        }
        int gcd = gcd(abs(nominator), abs(denominator));
        return nominator / gcd + ":" + denominator / gcd;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        LineThroughPoints objLTP = new LineThroughPoints();
        int[][] input =
                new int[][]{{1, 1}, {2, 2}, {3, 3}, {0, 4}, {-2, 6}, {4, 0}, {2, 1}};
        objLTP.lineThroughPoints(input);
    }
}
