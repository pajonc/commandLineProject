package com.chrzanop.coding.algoexpert.arrays;

public class MonotonicArray {


    // O(n) time | O(1) space
    public boolean isMonotonicSolution2(int[] array) {
        boolean nonDecreasing = true;
        boolean nonIcreasing = true;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                nonDecreasing = false;
            } else if (array[i] < array[i - 1] ) {
                nonIcreasing = false;
            }

        }

        return nonDecreasing || nonIcreasing;
    }


    // O(n) time | O(1) space
    public boolean isMonotonic(int[] array) {
        boolean validationResult = false;

        // 2 elements are still ok for this function
        if (array.length <= 2) {
            return true;
        }

        if (array[0] <= array[array.length - 1]) {
            validationResult = validateNonDecreasing(array);
        } else {
            validationResult = validateNonIncreasing(array);
        }

        return validationResult;
    }

    private boolean validateNonDecreasing(int[] array) {
        int tmp = array[0];
        for (int i = 1; i < array.length; i++) {
            if (tmp <= array[i]) {
                tmp = array[i];
            } else {
                return false;
            }
        }
        return true;


    }

    private boolean validateNonIncreasing(int[] array) {
        int tmp = array[0];
        for (int i = 1; i < array.length; i++) {
            if (tmp >= array[i]) {
                tmp = array[i];
            } else {
                return false;
            }
        }
        return true;
    }
}
