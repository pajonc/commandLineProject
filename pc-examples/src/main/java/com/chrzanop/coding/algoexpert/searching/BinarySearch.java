package com.chrzanop.coding.algoexpert.searching;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BinarySearch {

    @Test
    public void TestCase1() {

        assertTrue(binarySearch(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 33) == 3);
        assertTrue(binarySearchRecursive(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 33) == 3);
    }


    // O(log(n)) time | O(1) space
    public static int binarySearch(int[] array, int target) {

        int leftIdx = 0;
        int rightIdx = array.length - 1;

        while (leftIdx <= rightIdx) {
            int midIdx = (leftIdx + rightIdx) / 2;
            if (array[midIdx] == target) {
                return midIdx;
            } else if (array[midIdx] > target) {
                rightIdx = midIdx - 1;
            } else if (array[midIdx] < target) {
                leftIdx = midIdx + 1;
            }
        }
        return -1;
    }


    // O(log(n)) time | O(log(n)) space
    public static int binarySearchRecursive(int[] array, int target) {

        int midIdx = (0 + (array.length - 1)) / 2;

        return binarySearchRecursive(array, target, 0, array.length - 1);
    }


    public static int binarySearchRecursive(int[] array, int target, int leftIdx, int rightIdx) {

        if (leftIdx > rightIdx) {
            return -1;
        }
        int midIdx = (leftIdx + rightIdx) / 2;
        if (array[midIdx] == target) {
            return midIdx;
        }

        if (array[midIdx] > target) {
            rightIdx = midIdx - 1;
        } else if (array[midIdx] < target) {
            leftIdx = midIdx + 1;
        }

        return binarySearchRecursive(array, target, leftIdx, rightIdx);
    }


}
