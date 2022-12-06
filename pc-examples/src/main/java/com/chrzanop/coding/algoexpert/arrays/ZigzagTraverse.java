package com.chrzanop.coding.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ZigzagTraverse {


    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<List<Integer>>();
        test.add(new ArrayList<Integer>(Arrays.asList(1, 3, 4, 10)));
        test.add(new ArrayList<Integer>(Arrays.asList(2, 5, 9, 11)));
        test.add(new ArrayList<Integer>(Arrays.asList(6, 8, 12, 15)));
        test.add(new ArrayList<Integer>(Arrays.asList(7, 13, 14, 16)));
        List<Integer> expected =
                new ArrayList<Integer>(
                        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
        List<Integer> result = zigzagTraverse(test);
        assertTrue(result.equals(expected));
    }

    public static List<Integer> zigzagTraverse(List<List<Integer>> input) {
        int width = input.get(0).size() - 1;
        int height = input.size() - 1;
        List<Integer> result = new ArrayList<>(width * height);
        int row = 0, col = 0;
        boolean goingDown = true;

        while (!isOutOfBound(row, col, width, height)) {
            result.add(input.get(row).get(col));
            if (goingDown) {

//                if(row==height) {
//                    goingDown = false;
//                    col++;
//                } else if (col==0 && row < height) {
//                    goingDown = false;
//                    row++;
//                }
//                else {
//                    col--;
//                    row++;
//                }


                if (col == 0 || row == height) {
                    goingDown = false;
                    if (row == height) {
                        col++;
                    } else {
                        row++;
                    }
                } else {
                    col--;
                    row++;
                }

            } else {
                if (row == 0 || col == width) {
                    goingDown = true;
                    if (col == width) {
                        row++;
                    } else {
                        col++;
                    }
                } else {
                    row--;
                    col++;
                }
            }
        }

        return result;
    }

    private static boolean isOutOfBound(int row, int col, int width, int height) {
        return row < 0 || col < 0 || row > height || col > width;
    }


}
