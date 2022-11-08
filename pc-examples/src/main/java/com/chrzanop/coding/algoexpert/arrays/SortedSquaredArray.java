package com.chrzanop.coding.algoexpert.arrays;

import java.util.*;

// sorted array gives us suggestion that complexity might be O(n)
public class SortedSquaredArray {

    public static void main(String[] args) {
        int[] input = new int[] {1, 2, 3, 5, 6, 8, 9};
        int[] expected = new int[] {1, 4, 9, 25, 36, 64, 81};

        int[] actual = sortedSquaredArray(input);

        for (int i = 0; i < expected.length; i++) {
            System.out.println((expected[i] == actual[i]));
        }

        System.out.println("---------------");

        int[] input2 = new int[] {-7, -3, 1, 9 };
        int[] expected2 = new int[] {1, 9, 49, 81};

        int[] actual2 = sortedSquaredArray(input2);

        for (int i = 0; i < expected2.length; i++) {
            System.out.println((expected2[i] == actual2[i]));
        }
    }


    /*
    O(n) time | O(n) space
     */
    public static int[] sortedSquaredArray(int[] array) {

        int[] result = new int[array.length];
        int startIdx = 0, endIdx = array.length - 1;

        for (int i = array.length - 1; i >= 0; i--) {
            if (startIdx == endIdx && i == 0) {
                result[i] = array[i] * array[i];
            }
            int absLeftValue = Math.abs(array[startIdx]);
            int absRightValue = Math.abs(array[endIdx]);
            if (absLeftValue < absRightValue) {
                result[i] = absRightValue * absRightValue;
                endIdx = endIdx - 1;
            } else {
                result[i] = absLeftValue * absLeftValue;
                startIdx = startIdx + 1;
            }

        }
        return result;
    }


}
