package com.chrzanop.coding.algoexpert.arrays;

public class SubarraySort {

    // O(n) time | O(1) space
    public static int[] subarraySort(int[] array) {
        int leftMin = Integer.MAX_VALUE;
        int rightMax = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (isUnordered(i, num, array)) {
                leftMin = Math.min(leftMin, num);
                rightMax = Math.max(rightMax, num);
            }

        }

        if (leftMin == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        // left check index
        int leftIdx = 0;
        while (array[leftIdx] <= leftMin) {
            leftIdx++;
        }
        // right check index
        int rightIdx = array.length - 1;
        while (array[rightIdx] >= rightMax) {
            rightIdx--;
        }


        return new int[]{leftIdx, rightIdx};
    }

    private static boolean isUnordered(int i, int num, int[] array) {

        if (i == 0) {
            return num > array[i + 1];
        } else if (i == array.length - 1) {
            return num < array[i - 1];
        } else {
            return num < array[i - 1] || num > array[i + 1];
        }
    }

}