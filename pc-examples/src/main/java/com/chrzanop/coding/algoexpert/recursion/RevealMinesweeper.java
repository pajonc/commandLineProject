package com.chrzanop.coding.algoexpert.recursion;

import java.util.ArrayList;
import java.util.List;

public class RevealMinesweeper {

    // O(w * h) time | O(w * h) space where w is the width of the board, and
    // h is the height of the board
    public String[][] revealMinesweeper(String[][] board, int row, int column) {

        if (board[row][column].equals("M")) {
            board[row][column] = "X";
            return board;
        }

        List<CellLocation> neighbours = getNeighbours(board, row, column);
        int adjacentMinesCount = 0;
        for (CellLocation neighbour : neighbours) {
            if (board[neighbour.row][neighbour.column].equals("M")) {
                adjacentMinesCount++;
            }
        }

        if (adjacentMinesCount > 0) {
            board[row][column] = Integer.toString(adjacentMinesCount);
        } else {
            board[row][column] = "0";
            for (CellLocation neighbour : neighbours) {
                if (board[neighbour.row][neighbour.column].equals("H")) {
                    revealMinesweeper(board, neighbour.row, neighbour.column);
                }
            }
        }

        return board;
    }

    private List<CellLocation> getNeighbours(String[][] board, int row, int column) {
        List<CellLocation> neighbours = new ArrayList<>();
        int colSize = board[0].length;
        int rowSize = board.length;
        int[][] directions =
                new int[][]{{0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}, {1, -1}, {1, 0}, {1, 1}};

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newColumn = column + direction[1];

            if (newRow >= 0 && newRow < rowSize && newColumn >= 0 && newColumn < colSize) {
                neighbours.add(new CellLocation(newRow, newColumn));
            }
        }
        return neighbours;

    }

    private class CellLocation {
        int row;
        int column;

        public CellLocation(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
