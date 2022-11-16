package com.chrzanop.coding.algoexpert.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}};
        System.out.println("Rows " + array.length);
        System.out.println("Columns " + array[0].length);
        System.out.println(array[1][2]);
    }

    // O(n) time | O(n) space
    public List<Integer> spiralTraverse(int[][] array) {

        if (array.length == 0) return new ArrayList<>();

        int rows = array.length;
        int columns = array[0].length;
        List<Integer> result = new ArrayList<Integer>(rows * columns);

        int startRow = 0;
        int startColumn = 0;
        int endRow = rows - 1;
        int endColumn = columns - 1;

        while (startRow <= endRow && startColumn <= endColumn) {

            // top border inclusively
            for (int column = startColumn; column <= endColumn; column++) {
                result.add(array[startRow][column]);
            }

            // right border
            for (int row = startRow + 1; row <= endRow; row++) {
                result.add(array[row][endColumn]);
            }

            // bottom border / reverse
            for (int column = endColumn - 1; column >= startColumn; column--) {
                if (startRow == endRow) {
                    break;
                }
                result.add(array[endRow][column]);
            }

            // left border
            for (int row = endRow - 1; row > startRow; row--) {
                if (startColumn == endColumn) {
                    break;
                }
                result.add(array[row][startColumn]);
            }

            startRow++;
            endRow--;
            startColumn++;
            endColumn--;

        }
        return result;
    }

    public List<Integer> spiralTraverseRecursive(int[][] array) {

        int rows = array.length;
        int columns = array[0].length;
        List<Integer> result = new ArrayList<Integer>(rows * columns);

        int startRow = 0;
        int startColumn = 0;
        int endRow = rows - 1;
        int endColumn = columns - 1;

        spiralTraverseFill(array, startColumn, endColumn, startRow, endRow, result);

        return result;
    }


    private void spiralTraverseFill(int[][] array, int startColumn, int endColumn, int startRow, int endRow, List<Integer> result) {


        if (startColumn > endColumn || startRow > endRow) {
            return;
        }

        for (int column = startColumn; column <= endColumn; column++) {
            result.add(array[startRow][column]);
        }

        // right border
        for (int row = startRow + 1; row <= endRow; row++) {
            result.add(array[row][endColumn]);
        }

        // bottom border / reverse
        for (int column = endColumn - 1; column >= startColumn; column--) {
            if (startRow == endRow) {
                break;
            }
            result.add(array[endRow][column]);
        }

        // left border
        for (int row = endRow - 1; row > startRow; row--) {
            if (startColumn == endColumn) {
                break;
            }
            result.add(array[row][startColumn]);
        }

        spiralTraverseFill(array, startColumn + 1, endColumn - 1, startRow + 1, endRow - 1, result);


    }


}
