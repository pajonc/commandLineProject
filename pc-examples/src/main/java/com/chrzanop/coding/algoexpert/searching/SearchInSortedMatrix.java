package com.chrzanop.coding.algoexpert.searching;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SearchInSortedMatrix {


    @Test
    public void TestCase1() {
        int[][] matrix = {
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004},
        };

        int[] expected = {3, 3};
        int[] output = searchInSortedMatrix(matrix, 44);
        assertTrue(compare(output, expected));
    }

    public boolean compare(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }


    // O(n+m) time | O(1) space
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {

        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                return new int[]{row, col};
            }
        }
        return new int[]{-1, -1};
    }


}
