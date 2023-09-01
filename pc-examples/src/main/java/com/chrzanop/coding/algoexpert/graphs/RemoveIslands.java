package com.chrzanop.coding.algoexpert.graphs;

public class RemoveIslands {


    // O(wh) time | O(wh) space - where w and h
    // are the width and height of the input matrix
    public int[][] removeIslands(int[][] matrix) {

        boolean[][] onesConnectedToBorder = new boolean[matrix.length][matrix[0].length];
        // find all in the 1st that are not island
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                boolean rowIsBorder = row == 0 || row == matrix.length - 1;
                boolean colIsBorder = col == 0 || col == matrix[row].length - 1;
                boolean isBorder = rowIsBorder || colIsBorder;

                if (!isBorder) {
                    continue;
                }

                if (matrix[row][col] != 1) {
                    continue;
                }

                findOnesConnectedToBorder(matrix, row, col, onesConnectedToBorder);
            }
        }

        // fill with 0 inner matrix which is not connected with the border
        for (int row = 1; row < matrix.length - 1; row++) {
            for (int col = 1; col < matrix[0].length - 1; col++) {
                if (onesConnectedToBorder[row][col]) {
                    continue;
                }
                matrix[row][col] = 0;
            }
        }
        return matrix;
    }

    private void findOnesConnectedToBorder(int[][] matrix, int startRow, int startCol, boolean[][] onesConnectedToBorder) {
        if (!isWithinMatrix(startRow, startCol, matrix) || matrix[startRow][startCol] != 1 || onesConnectedToBorder[startRow][startCol]) {
            return;
        }
        onesConnectedToBorder[startRow][startCol] = true;
        int[][] coordinates = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < coordinates.length; i++) {
            findOnesConnectedToBorder(matrix, startRow + coordinates[i][0], startCol + coordinates[i][1], onesConnectedToBorder);
        }
    }

    private boolean isWithinMatrix(int row, int col, int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (row < 0 || col < 0 || row > rows - 1 || col > cols - 1) {
            return false;
        }
        return true;
    }

}
