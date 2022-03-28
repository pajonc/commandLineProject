package com.chrzanop.graph.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {



    public static void main(String[] args) {

        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] image2 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int newColor = 2;
        int oldColor = 1;
        int row = 1;
        int col = 1;

        FloodFill floodFill = new FloodFill();

//        int[][] imageRes = floodFill.floodFillDFS(image, row, col, oldColor, newColor);

        int[][] image2Res = floodFill.floodFillBFS(image2, row, col, oldColor, newColor);

//        System.out.println(imageRes);

        System.out.println(image2Res);


    }

    public int[][] floodFillDFS(int[][] image, int sr, int sc, int color, int newColor) {

        fillDFS(image, sr, sc, color, newColor);

        return image;
    }

    public int[][] floodFillBFS(int[][] image, int sr, int sc, int color, int newColor) {

        fillBFS(image, sr, sc, color, newColor);

        return image;
    }


    private void fillBFS(int[][] image, int row, int col, int color, int newColor) {
        if (image[row][col] == newColor) {
            return;
        }
        int[][] shifts = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(row, col));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            image[pair.x][pair.y] = newColor;
            for (int[] shift : shifts) {
                if (pair.x + shift[0] < 0
                        || pair.y + shift[1] < 0
                        || pair.x + shift[0] >= image.length
                        || pair.y + shift[1] >= image[0].length
                        || image[pair.x+shift[0]][pair.y+shift[1]] != color) {
                    continue;
                }
                queue.offer(new Pair(pair.x + shift[0], pair.y + shift[1]));
            }
//
//            queue.offer(new Pair(pair.x + shifts[0][0], pair.y + shifts[0][1]));
//            queue.offer(new Pair(pair.x + shifts[1][0], pair.y + shifts[1][1]));
//            queue.offer(new Pair(pair.x + shifts[2][0], pair.y + shifts[2][1]));
//            queue.offer(new Pair(pair.x + shifts[3][0], pair.y + shifts[3][1]));
        }
    }


    private void fillDFS(int[][] image, int row, int col, int color, int newColor) {

        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length || image[row][col] != color) {
            return;
        }
        image[row][col] = newColor;
        int[][] coordinates = {{row - 1, col}, {row + 1, col}, {row, col + 1}, {row, col - 1}};

//        fillDFS(image, coordinates[0][0], coordinates[0][1], color, newColor);
//        fillDFS(image, coordinates[1][0], coordinates[1][1], color, newColor);
//        fillDFS(image, coordinates[2][0], coordinates[2][1], color, newColor);
//        fillDFS(image, coordinates[3][0], coordinates[3][1], color, newColor);

        for (int[] coordinate : coordinates) {
            fillDFS(image, coordinate[0], coordinate[1], color, newColor);
        }

    }

    class Pair {

        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
