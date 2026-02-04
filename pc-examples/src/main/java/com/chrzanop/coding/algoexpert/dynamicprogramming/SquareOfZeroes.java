package com.chrzanop.coding.algoexpert.dynamicprogramming;

import java.util.ArrayList;
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

    // O(n^4) time | O(1) space - n height and width of the matrix
    public static boolean squareOfZeroesAlgo2(List<List<Integer>> matrix) {
        boolean result = false;
        int n = matrix.size();

        for (int topRow = 0; topRow < n; topRow++) {
            for (int leftCol = 0; leftCol < n; leftCol++) {
                int squareLength = 2;
                while (squareLength <= n - topRow && squareLength <= n - leftCol) {
                    int bottomRow = topRow + squareLength - 1;
                    int rightCol = leftCol + squareLength - 1;
                    if (isSquareOfZeros(matrix, topRow, leftCol, bottomRow, rightCol))
                        return true;
                    squareLength++;
                }

            }
        }

        return result;
    }


    // O(n^3) time | O(n^3) space - n height and width of the matrix
    public static boolean squareOfZeroesAlgo1Enhanced(List<List<Integer>> matrix) {
        List<List<InfoMatrixItem>> infoMatrix = preComputedNumOfZeroes(matrix);
        Map<String, Boolean> cache = new HashMap<>();
        int lastIdx = matrix.size() - 1;
        return hasSquareOfZerosEnhanced(infoMatrix, 0, 0, lastIdx, lastIdx, cache);
    }

    private static boolean hasSquareOfZerosEnhanced(List<List<InfoMatrixItem>> infoMatrix, int r1, int c1, int r2, int c2, Map<String, Boolean> cache) {
        if (r1 >= r2 || c1 >= c2) return false;

        String key = String.valueOf(r1) + '-' + String.valueOf(c1) + '-' + String.valueOf(r2) + '-' + String.valueOf(c2);

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        cache.put(key, isSquareOfZerosEnhanced(infoMatrix, r1, c1, r2, c2)
                || hasSquareOfZerosEnhanced(infoMatrix, r1 + 1, c1 + 1, r2 - 1, c2 - 1, cache)
                || hasSquareOfZerosEnhanced(infoMatrix, r1, c1 + 1, r2 - 1, c2, cache)
                || hasSquareOfZerosEnhanced(infoMatrix, r1 + 1, c1, r2, c2 - 1, cache)
                || hasSquareOfZerosEnhanced(infoMatrix, r1 + 1, c1 + 1, r2, c2, cache)
                || hasSquareOfZerosEnhanced(infoMatrix, r1, c1, r2 - 1, c2 - 1, cache));

        return cache.get(key);

    }


    // O(n^4) time | O(n^3) space - n height and width of the matrix
    public static boolean squareOfZeroesAlgo1(List<List<Integer>> matrix) {
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

//        boolean check = isSquareOfZeros(matrix, r1, c1, r2, c2)
//                || hasSquareOfZeros(matrix, r1 + 1, c1 + 1, r2 - 1, c2 - 1, cache)
//                || hasSquareOfZeros(matrix, r1, c1 + 1, r2 - 1, c2, cache)
//                || hasSquareOfZeros(matrix, r1 + 1, c1, r2, c2 - 1, cache)
//                || hasSquareOfZeros(matrix, r1 + 1, c1 + 1, r2, c2, cache)
//                || hasSquareOfZeros(matrix, r1, c1, r2 - 1, c2 - 1, cache);
//        cache.put(key, check);

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

    // r1 is the top row, c1 is the left column
    // r2 is the bottom row, c2 is the right column
    private static Boolean isSquareOfZerosEnhanced(List<List<InfoMatrixItem>> infoMatrix, int r1, int c1, int r2, int c2) {

        int squareLength = c2 - c1 + 1;

        boolean hasTopBorder = infoMatrix.get(r1).get(c1).numZerosRight >= squareLength;
        boolean hasLeftBorder = infoMatrix.get(r1).get(c1).numZerosBelow >= squareLength;
        boolean hasBottomBorder = infoMatrix.get(r2).get(c1).numZerosRight >= squareLength;
        boolean hasRightBorder = infoMatrix.get(r1).get(c2).numZerosBelow >= squareLength;

        return hasTopBorder && hasLeftBorder && hasBottomBorder && hasRightBorder;
    }


    public static List<List<InfoMatrixItem>> preComputedNumOfZeroes(List<List<Integer>> matrix) {
        List<List<InfoMatrixItem>> infoMatrix = new ArrayList<List<InfoMatrixItem>>();

        for (int i = 0; i < matrix.size(); i++) {
            List<InfoMatrixItem> inner = new ArrayList<>();
            for (int j = 0; j < matrix.get(i).size(); j++) {
                int numZeroes = matrix.get(i).get(j) == 0 ? 1 : 0;
                InfoMatrixItem item = new InfoMatrixItem(numZeroes, numZeroes);
                inner.add(item);
            }
            infoMatrix.add(inner);
        }

        int lastIdx = matrix.size() - 1;
        for (int row = lastIdx; row >= 0; row--) {
            for (int col = lastIdx; col >= 0; col--) {
                if (matrix.get(row).get(col) == 1) continue;
                if (row < lastIdx) {
                    infoMatrix.get(row).get(col).numZerosBelow +=
                            infoMatrix.get(row + 1).get(col).numZerosBelow;
                }
                if (col < lastIdx) {
                    infoMatrix.get(row).get(col).numZerosRight +=
                            infoMatrix.get(row).get(col + 1).numZerosRight;
                }
            }
        }
        return infoMatrix;
    }

    static class InfoMatrixItem {
        public int numZerosBelow;
        public int numZerosRight;

        public InfoMatrixItem(int numZerosBelow, int numZerosRight) {
            this.numZerosBelow = numZerosBelow;
            this.numZerosRight = numZerosRight;
        }
    }


}
