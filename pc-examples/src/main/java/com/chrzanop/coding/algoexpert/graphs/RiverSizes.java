package com.chrzanop.coding.algoexpert.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RiverSizes {


    // O(w*h) time | O(w*h) space - where w is width
    // and h is the height of the matrix respectively
    public List<Integer> riverSizes(int[][] matrix) {
        List<Integer> sizes = new ArrayList<Integer>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!visited[i][j]) {
                    int size = calculateSize(matrix, visited, i, j);
                    if (size > 0) sizes.add(size);
                }
            }
        }
        return sizes;
    }

    private int calculateSize(int[][] matrix, boolean[][] visited, int row, int col) {
        int size = 0;
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{row, col});
        int[][] coordinates = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!stack.isEmpty()) {
            Integer[] currentCooridnates = stack.pop();
            if (visited[currentCooridnates[0]][currentCooridnates[1]]) {
                continue;
            }
            visited[currentCooridnates[0]][currentCooridnates[1]] = true;
            if (matrix[currentCooridnates[0]][currentCooridnates[1]] == 1) {
                size += 1;
                for (int i = 0; i < coordinates.length; i++) {
                    int updatedRow = currentCooridnates[0] + coordinates[i][0];
                    int updatedCol = currentCooridnates[1] + coordinates[i][1];
                    if (updatedRow >= 0 && updatedRow < matrix.length && updatedCol >= 0 && updatedCol < matrix[0].length) {
                        stack.push(new Integer[]{updatedRow, updatedCol});
                    }
                }
            }
        }
        return size;
    }


}
