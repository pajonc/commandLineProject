package com.chrzanop.coding.algoexpert.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class MaximizeExpression {

    // O(4n) time --> O(n) time | O(4n) time --> O(n) space
    public int maximizeExpressionAlgo(int[] array) {

        int[] maxA = new int[array.length];
        int[] maxAMinusB = new int[array.length];
        int[] maxAMinusBPlusC = new int[array.length];
        int[] maxAMinusBPlusCMinusD = new int[array.length];

        int maxAValue = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            maxAValue = Math.max(array[i], maxAValue);
            maxA[i] = maxAValue;
        }

        int maxAMinusBValue = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            maxAMinusBValue = Math.max(maxA[i - 1] - array[i], maxAMinusBValue);
            maxAMinusB[i] = maxAMinusBValue;
        }

        int maxAMinusBPlusCValue = Integer.MIN_VALUE;
        for (int i = 2; i < array.length; i++) {
            maxAMinusBPlusCValue = Math.max(maxAMinusB[i - 1] + array[i], maxAMinusBPlusCValue);
            maxAMinusBPlusC[i] = maxAMinusBPlusCValue;
        }

        int maxAMinusBPlusCMinusDValue = Integer.MIN_VALUE;
        for (int i = 3; i < array.length; i++) {
            maxAMinusBPlusCMinusDValue = Math.max(maxAMinusBPlusC[i - 1] - array[i], maxAMinusBPlusCMinusDValue);
            maxAMinusBPlusCMinusD[i] = maxAMinusBPlusCMinusDValue;
        }

        return maxAMinusBPlusCMinusD[maxAMinusBPlusCMinusD.length - 1];
    }


    // O(n^4) time | O(1) space
    public int maximizeExpression(int[] array) {

        if (array.length < 4) return 0;
        int maximumExpression = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int a = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int b = array[j];
                for (int k = j + 1; k < array.length; k++) {
                    int c = array[k];
                    for (int l = k + 1; l < array.length; l++) {
                        int d = array[l];
                        int sum = a - b + c - d;
                        System.out.println("sum " + sum);
                        maximumExpression = Math.max(maximumExpression, sum);
                    }
                }
            }
        }

        return maximumExpression;
    }

    // O(n^2*n!) time | O(n*n!) space - permutations complexity
    public int maximizeExpressionRec(int[] array) {
        if (array.length < 4) {
            return 0;
        }
        Integer maximumExpression = Integer.MIN_VALUE;
        return maximumExpressionRecursively(array, 0, 0, maximumExpression, 0, true);
    }

    private int maximumExpressionRecursively(int[] array, int counter, int windowCounter, int maximumExpression, int localSum, boolean sign) {

        if (windowCounter == 4) {
            System.out.println("localSum "+localSum);
            return Math.max(maximumExpression, localSum);
        }

        for (int i = counter; i < array.length; i++) {

            int localValue = array[i];
            if (sign) {
                localSum = localSum + localValue;
            } else {
                localSum = localSum - localValue;
            }
            maximumExpression = maximumExpressionRecursively(array, i + 1, windowCounter + 1, maximumExpression, localSum, !sign);
            if (sign) {
                localSum = localSum - localValue;
            } else {
                localSum = localSum + localValue;
            }

//            System.out.println("i: " + i + " max: " + maximumExpression);
        }

        return maximumExpression;
    }


    // O(n^2*n!) time | O(n*n!) space - permutations complexity
    public int maximizeExpressionRecursivelyBackTrack(int[] array) {
        if (array.length < 4) {
            return 0;
        }

        ArrayList<Integer> sums = new ArrayList<>();
        ArrayList<Integer> subSums = new ArrayList<>();
        backTrack(array, sums, 0, subSums);

        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < subSums.size(); i++) {
            maxValue = Math.max(maxValue, subSums.get(i));
        }

        return maxValue;
    }

    private void backTrack(int[] array, List<Integer> sums, int idx, List<Integer> subSums) {

        if (sums.size() == 4) {
            boolean sign = true;
            int localSum = getLocalSum(sums, sign);
            subSums.add(localSum);
            return;
        }

        for (int i = idx; i < array.length; i++) {
            sums.add(array[i]);
            backTrack(array, sums, i + 1, subSums);
            sums.remove(sums.size() - 1);
        }
    }

    private static int getLocalSum(List<Integer> sums, boolean sign) {
        int localSum = 0;
        for (int i = 0; i < sums.size(); i++) {
            if (sign) {
                localSum = localSum + sums.get(i);
            } else {
                localSum = localSum - sums.get(i);
            }
            sign = !sign;
        }
        return localSum;
    }


}
