package com.chrzanop.coding.algoexpert.dynamicprogramming;

public class MaxSubsetSumNoAdjacent {


    // O(n) time | O(n) space where n is the number of array length
    public static int maxSubsetSumNoAdjacent(int[] array) {
        int[] maxSumArray = new int[array.length];
        if (array.length == 0) return 0;
        if (array.length == 1) return array[0];
        if (array.length == 2) return Math.max(array[0], array[1]);

        maxSumArray[0] = array[0];
        maxSumArray[1] = Math.max(array[0], array[1]);

        for (int i = 2; i < array.length; i++) {
            maxSumArray[i] = Math.max(maxSumArray[i - 2] + array[i], maxSumArray[i - 1]);
        }

        return maxSumArray[array.length - 1];
    }
}


