package com.chrzanop.leetcode;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        NumberOfIslands numberOfIslands = new NumberOfIslands();
        int counter = numberOfIslands.numIslands(grid);
        System.out.println("Finish: " + counter);
    }


    public int numIslands(char[][] grid) {

        int counter = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                char element = grid[row][col];
                if (element == '0') {
                    continue;
                } else if (element == '1') {
                    dfsSearch(grid, row, col);
                    counter++;
                }
            }
        }
        return counter;

    }

    private void dfsSearch(char[][] grid, int row, int col) {
        int m = grid.length, n = grid[0].length;
        int[][] coordinates = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        for (int[] coordinate : coordinates) {
            dfsSearch(grid, row + coordinate[0], col + coordinate[1]);
        }

    }


}
