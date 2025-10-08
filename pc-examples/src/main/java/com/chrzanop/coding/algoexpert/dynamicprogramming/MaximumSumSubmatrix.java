package com.chrzanop.coding.algoexpert.dynamicprogramming;

public class MaximumSumSubmatrix {

    // O(m*n*size^2) time | where m and n are the width and height of the matrix
    public int maximumSumSubmatrix(int[][] matrix, int size) {

        int maxSum = Integer.MIN_VALUE;
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;

        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                int localMax = 0;
                if (i + size < maxRow && j + size < maxCol) {
                    for (int k = i; k < i + size; k++) {
                        for (int l = j; l < j + size; l++) {
                            localMax += matrix[k][l];
                        }
                    }
                }
                maxSum = Math.max(localMax, maxSum);
            }
        }

        return maxSum;
    }

    // O(m*n) time |  O(m*n) space - where m and n are the width and height of the matrix
    public int maximumSumSubmatrixAlgoMine(int[][] matrix, int size) {

        int maxSum = Integer.MIN_VALUE;
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;

        int[][] sums = matrixSums(matrix);

        for (int i = size - 1; i < maxRow; i++) {
            for (int j = size - 1; j < maxCol; j++) {
                int sumsLeft = 0;
                if (j - size >= 0) {
                    sumsLeft = sums[i][j - size];
                }
                int sumsAbove = 0;
                if (i - size >= 0) {
                    sumsAbove = sums[i - size][j];
                }

                int sumOverlap = 0;
                if (j - size >= 0 && i - size >= 0) {
                    sumOverlap = sums[i - size][j - size];
                }

                maxSum = Math.max(sums[i][j] - sumsAbove - sumsLeft + sumOverlap, maxSum);
            }
        }

        return maxSum;
    }

    // O(m*n) time |  O(m*n) space - where m and n are the width and height of the matrix
    private static int[][] matrixSums(int[][] matrix) {
        int[][] sums = new int[matrix.length][matrix[0].length];
        // sum first row
        for (int i = 0; i < matrix[0].length; i++) {
            if (i == 0) {
                sums[0][i] = matrix[0][i];
                continue;
            }
            sums[0][i] = sums[0][i - 1] + matrix[0][i];
        }
        // sum first column
        for (int i = 0; i < matrix.length; i++) {
            if (i == 0) {
                sums[i][0] = matrix[i][0];
                continue;
            }
            sums[i][0] = sums[i - 1][0] + matrix[i][0];
        }
        // fill rest of the matrix
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                sums[i][j] = matrix[i][j] + sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1];
            }
        }
        return sums;
    }


    public int maximumSumSubmatrixAlgo(int[][] matrix, int size) {
        int[][] sums = createSumMatrix(matrix);
        int maxSubMatrixSum = Integer.MIN_VALUE;

        for (int row = size - 1; row < matrix.length; row++) {
            for (int col = size - 1; col < matrix[row].length; col++) {
                int total = sums[row][col];

                boolean touchesTopBorder = (row - size < 0);
                if (!touchesTopBorder) {
                    total -= sums[row - size][col];
                }

                boolean touchesLeftBorder = (col - size < 0);
                if (!touchesLeftBorder) {
                    total -= sums[row][col - size];
                }

                boolean touchesTopOrLeftBorder = (touchesTopBorder || touchesLeftBorder);
                if (!touchesTopOrLeftBorder) {
                    total += sums[row - size][col - size];
                }

                maxSubMatrixSum = Math.max(maxSubMatrixSum, total);
            }
        }
        return maxSubMatrixSum;
    }

    private int[][] createSumMatrix(int[][] matrix) {
        int[][] sums = new int[matrix.length][matrix[0].length];
        sums[0][0] = matrix[0][0];
        // fill the first row
        for (int idx = 1; idx < matrix[0].length; idx++) {
            sums[0][idx] = sums[0][idx-1] + matrix[0][idx];
        }
        // fill the first column
        for (int idx = 1; idx < matrix.length; idx++) {
            sums[idx][0] = sums[idx-1][0] + matrix[idx][0];
        }
        // fill in the rest of the matrix
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                sums[row][col] = sums[row][col-1] + sums[row-1][col] - sums[row-1][col-1] + matrix[row][col];
            }
        }
        return sums;
    }


}
