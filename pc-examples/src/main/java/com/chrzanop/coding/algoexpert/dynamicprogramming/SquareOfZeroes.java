package com.chrzanop.coding.algoexpert.dynamicprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SquareOfZeroes {

    public static boolean squareOfZeroes(List<List<Integer>> matrix) {

        int nSize = matrix.size();
        int window = 2;

        while (window <= nSize) {
            int numberOfShifts = nSize - window + 1;

            for (int rowShift = 0; rowShift < numberOfShifts; rowShift++) {
                for (int colShift = 0; colShift < numberOfShifts; colShift++) {

                    boolean isSquare = true;

                    // top
                    int topRow = rowShift;
                    for (int col = colShift; col < window + colShift; col++) {
                        if (matrix.get(topRow).get(col) != 0) {
                            isSquare = false;
                            break;
                        }
                    }
                    if (!isSquare) continue;
                    // left
                    int leftCol = colShift;
                    for (int row = rowShift; row < window + rowShift; row++) {
                        if (matrix.get(row).get(leftCol) != 0) {
                            isSquare = false;
                            break;
                        }
                    }
                    if (!isSquare) continue;
                    //right
                    int rightCol = colShift + window - 1;
                    for (int row = rowShift; row < window + rowShift; row++) {
                        if (matrix.get(row).get(rightCol) != 0) {
                            isSquare = false;
                            break;
                        }
                    }
                    if (!isSquare) continue;
                    //bottom
                    int bottowRow = rowShift + window - 1;
                    for (int col = colShift; col < window + colShift; col++) {
                        if (matrix.get(bottowRow).get(col) != 0) {
                            isSquare = false;
                            break;
                        }
                    }
                    if (!isSquare) continue;

                    if (isSquare) {
                        return true;
                    }
                }
            }
            window++;
        }


        return false;
    }

    // O(n^4) time | O(n^3) space - n height and width of the matrix
    public static boolean squareOfZeroesAlgo(List<List<Integer>> matrix) {
        int lastIdx = matrix.size() - 1;
        Map<String, Boolean> cache = new HashMap<>();
        boolean result = hasSquareOfZeros(matrix, 0, 0, lastIdx, lastIdx, cache);
        return result;

    }

    private static boolean hasSquareOfZeros(List<List<Integer>> matrix, int r1, int c1, int r2, int c2, Map<String, Boolean> cache) {
        if (r1 >= r2 || c1 >= c2) return false;

        String key = String.valueOf(r1) + '-' + String.valueOf(c1) + '-' + String.valueOf(r2) + '-' + String.valueOf(c2);

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        cache.put(key, isSquareOfZeros(matrix, r1, c1, r2, c2)
                || hasSquareOfZeros(matrix, r1 + 1, c1 + 1, r2 - 1, c2 - 1, cache)
                || hasSquareOfZeros(matrix, r1, c1 + 1, r2 - 1, c2, cache)
                || hasSquareOfZeros(matrix, r1 + 1, c1, r2, c2 - 1, cache)
                || hasSquareOfZeros(matrix, r1 + 1, c1 + 1, r2, c2, cache)
                || hasSquareOfZeros(matrix, r1, c1, r2 - 1, c2 - 1, cache));

        return cache.get(key);

    }

    // r1 is the top row, c1 is the left column
    // r2 is the bottom row, c2 is the right column
    private static Boolean isSquareOfZeros(List<List<Integer>> matrix, int r1, int c1, int r2, int c2) {

        for (int row = r1; row < r2 + 1; row++) {
            if (matrix.get(row).get(c1) != 0 || matrix.get(row).get(c2) != 0) {
                return false;
            }
        }
        for (int col = c1; col < c2 + 1; col++) {
            if (matrix.get(r1).get(col) != 0 || matrix.get(r2).get(col) != 0) {
                return false;
            }

        }
        return true;
    }


}
