package com.chrzanop.coding.algoexpert.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LargestIsland {


    // O(w^2*h^2) time | O(w*h) space - where w is the width and h height of the matrix
    public int largestIsland(int[][] matrix) {
        int maxSize = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    continue;
                }
                maxSize = Math.max(maxSize, getSizeFromNode(row, col, matrix));
            }
        }

        return maxSize;

    }

    private int getSizeFromNode(int row, int col, int[][] matrix) {
        int size = 1;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Stack<List<Integer>> nodesToExplore = new Stack<>();
        getLandNeighbors(row, col, matrix, nodesToExplore);
        while (!nodesToExplore.isEmpty()) {
            List<Integer> currentNode = nodesToExplore.pop();
            int currentRow = currentNode.get(0);
            int currentCol = currentNode.get(1);

            if(visited[currentRow][currentCol]) {
                continue;
            }
            visited[currentRow][currentCol] = true;
            size++;
            getLandNeighbors(currentRow, currentCol, matrix, nodesToExplore);
        }
        return size;
    }

    private void getLandNeighbors(int row, int col, int[][] matrix, Stack<List<Integer>> nodesToExplore) {
        if (row > 0 && matrix[row - 1][col] != 1) {
            nodesToExplore.push(Arrays.asList(row - 1, col));
        }
        if (row < matrix.length - 1 && matrix[row + 1][col] != 1) {
            nodesToExplore.push(Arrays.asList(row + 1, col));
        }
        if (col > 0 && matrix[row][col - 1] != 1) {
            nodesToExplore.push(Arrays.asList(row, col - 1));
        }
        if (col < matrix[0].length - 1 && matrix[row][col + 1] != 1) {
            nodesToExplore.push(Arrays.asList(row, col + 1));
        }
    }


    public int largestIsland2(int[][] matrix) {

        int maxSize = 1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                maxSize = Math.max(maxSize, getLandSize(row, col, matrix));
            }
        }

        return maxSize;
    }

    private int getLandSize(int row, int col, int[][] matrix) {
        boolean changed = true;
        if (matrix[row][col] == 1) {
            matrix[row][col] = 0;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(matrix[row][col]);
        while (!stack.isEmpty()) {
            pushNeighbours(row, col, stack, matrix);
        }


        if (changed) matrix[row][col] = 1;

        return 1;

    }

    private void pushNeighbours(int row, int col, Stack<Integer> stack, int[][] matrix) {
        if (row - 1 >= 0 && matrix[row - 1][col] == 0) {
            stack.push(matrix[row - 1][col]);
        }
        if (row + 1 < matrix.length && matrix[row + 1][col] == 0) {
            stack.push(matrix[row - 1][col]);
        }
        if (col - 1 >= 0 && matrix[col - 1][row] == 0) {
            stack.push(matrix[col - 1][row]);
        }
        if (col + 1 < matrix[0].length && matrix[col + 1][row] == 0) {
            stack.push(matrix[col + 1][row]);
        }
    }


}
