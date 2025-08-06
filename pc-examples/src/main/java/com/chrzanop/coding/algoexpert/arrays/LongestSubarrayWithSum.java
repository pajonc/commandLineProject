package com.chrzanop.coding.algoexpert.arrays;

public class LongestSubarrayWithSum {

    public int[] longestSubarrayWithSum(int[] array, int targetSum) {
        int[] indicies = new int[]{};

        int currentSubarraySum = 0;
        int startingIndex = 0;
        int endingIndex = 0;

        while (endingIndex < array.length) {
            currentSubarraySum += array[endingIndex];
            while (startingIndex < endingIndex && currentSubarraySum > targetSum) {
                currentSubarraySum -= array[startingIndex];
                startingIndex++;
            }

            if (currentSubarraySum == targetSum) {
                if (indicies.length == 0 || endingIndex - startingIndex > indicies[1] - indicies[0]) {
                    indicies = new int[]{startingIndex, endingIndex};
                }
            }

            endingIndex++;
        }


//        int i = 0, j=0;
//        int targetIdStart = i, targetIdEnd = j;
//        int windowLength = 0;
//
//        int targetSumCalc = 0;
//        for (int k = 0; k < array.length; k++) {
//            int value = array[k];
//            targetSumCalc += value;
//            if(targetSumCalc == targetSum) {
//                if(j-i > windowLength) {
//                    windowLength = j - i;
//                    targetIdStart = i;
//                    targetIdEnd = j;
//                }
//                targetSumCalc = targetSumCalc - array[i];
//                i = i+1;
//            } else if (targetSumCalc > targetSum) {
//                targetSumCalc = targetSumCalc - array[i];
//                i = i+1;
//            }
//            j = j + 1;
//        }

        return indicies;
    }

}
