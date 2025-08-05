package com.chrzanop.coding.algoexpert.arrays;

public class LongestSubarrayWithSum {

    public int[] longestSubarrayWithSum(int[] array, int targetSum) {
        int i = 0, j=0;
        int targetIdStart = i, targetIdEnd = j;
        int windowLength = 0;

        int targetSumCalc = 0;
        for (int k = 0; k < array.length; k++) {
            int value = array[k];
            targetSumCalc += value;
            if(targetSumCalc == targetSum) {
                if(j-i > windowLength) {
                    windowLength = j - i;
                    targetIdStart = i;
                    targetIdEnd = j;
                }
                targetSumCalc = targetSumCalc - array[i];
                i = i+1;
            } else if (targetSumCalc > targetSum) {
                targetSumCalc = targetSumCalc - array[i];
                i = i+1;
            }
            j = j + 1;
        }

        return new int[] {targetIdStart, targetIdEnd};
    }

}
