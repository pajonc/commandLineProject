package com.chrzanop.coding.algoexpert.sorting;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BubbleSort {

    // Best: O(n) time | O(1) space
    // Average: O(n^2) time | O(1) space
    // Worst: O(n^2) time | O(1) space
    public static int[] bubbleSort(int[] array) {
        boolean swapped = true;
        int size = array.length;

        while (swapped) {
            swapped = false;
            for (int i = 1; i < size; i++) {
                if (array[i - 1] > array[i]) {
                    swap(i - 1, i, array);
                    swapped = true;
                }
            }
            size -= 1;
        }
        return array;
    }


    private static void swap(int i, int j, int[] array) {
        int iElement = array[i];
        array[i] = array[j];
        array[j] = iElement;
    }



    @Test
    public void TestCase1() {
        int[] expected = {2, 3, 5, 5, 6, 8, 9};
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        assertTrue(compare(bubbleSort(input), expected));
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


}
