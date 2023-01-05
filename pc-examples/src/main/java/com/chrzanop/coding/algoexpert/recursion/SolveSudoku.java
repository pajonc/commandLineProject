package com.chrzanop.coding.algoexpert.recursion;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class SolveSudoku {

    @Test
    public void shouldPassSudoku() {
        int[][] inputValues =
                new int[][]{
                        {7, 8, 0, 4, 0, 0, 1, 2, 0},
                        {6, 0, 0, 0, 7, 5, 0, 0, 9},
                        {0, 0, 0, 6, 0, 1, 0, 7, 8},
                        {0, 0, 7, 0, 4, 0, 2, 6, 0},
                        {0, 0, 1, 0, 5, 0, 9, 3, 0},
                        {9, 0, 4, 0, 6, 0, 0, 0, 5},
                        {0, 7, 0, 3, 0, 0, 0, 1, 2},
                        {1, 2, 0, 0, 0, 7, 4, 0, 0},
                        {0, 4, 9, 2, 0, 6, 0, 0, 7}
                };
        int[][] expectedValues =
                new int[][]{
                        {7, 8, 5, 4, 3, 9, 1, 2, 6},
                        {6, 1, 2, 8, 7, 5, 3, 4, 9},
                        {4, 9, 3, 6, 2, 1, 5, 7, 8},
                        {8, 5, 7, 9, 4, 3, 2, 6, 1},
                        {2, 6, 1, 7, 5, 8, 9, 3, 4},
                        {9, 3, 4, 1, 6, 2, 7, 8, 5},
                        {5, 7, 8, 3, 9, 4, 6, 1, 2},
                        {1, 2, 6, 5, 8, 7, 4, 9, 3},
                        {3, 4, 9, 2, 1, 6, 8, 5, 7}
                };

        ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < inputValues.length; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < inputValues[i].length; j++) {
                row.add(inputValues[i][j]);
            }
            input.add(row);
        }

        ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < expectedValues.length; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < expectedValues[i].length; j++) {
                row.add(expectedValues[i][j]);
            }
            expected.add(row);
        }

        System.out.println("-------------");

        ArrayList<ArrayList<Integer>> actual = solveSudoku(input);
        assertTrue(expected.equals(actual));
    }




    public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {

        boolean sudoku = solvePartialSudoku(board, 0, 0);
        return board;
    }

    private boolean solvePartialSudoku(ArrayList<ArrayList<Integer>> board, int row, int col) {

        int currentRow = row;
        int currentCol = col;

        if(currentCol == board.get(currentRow).size()) {
            currentRow = currentRow + 1;
            currentCol = 0;
            if (currentRow == board.size()) {
                return true;
            }
        }

        if(board.get(currentRow).get(currentCol) == 0) {
            return tryDigitsAtPosition(board, currentRow, currentCol);
        }

        return solvePartialSudoku(board, currentRow, currentCol+1);
    }

    private boolean tryDigitsAtPosition(ArrayList<ArrayList<Integer>> board, int row, int col) {

        for (int digit = 1; digit < 10; digit++) {
            if(isValidAtPosition(board, row, col, digit)) {
                System.out.println("row "+row +" col "+col + " digit "+digit);
                board.get(row).set(col, digit);
                if(solvePartialSudoku(board, row, col +1)) {
                    return true;
                }
            }
        }

        board.get(row).set(col, new Integer(0));
        return false;
    }

    private boolean isValidAtPosition(ArrayList<ArrayList<Integer>> board, int row, int col, int digit) {

        boolean isValidRow = !board.get(row).contains(digit);
        boolean isValidCol = true;
        for (int i = 0; i < 9; i++) {
            if(board.get(i).get(col) == digit) {
                isValidCol = false;
                break;
            }
        }

        boolean isValidSubMatrix = true;
        int startRowIdx = (row / 3) * 3 ;
        int startColIdx = (col / 3) * 3;
        for (int i = startRowIdx; i < startRowIdx + 3; i++) {
            for (int j = startColIdx; j < startColIdx + 3; j++) {

                if(board.get(i).get(j) == digit) {
                    isValidSubMatrix = false;
                }
            }
        }

        return isValidRow && isValidCol && isValidSubMatrix;
    }


}
