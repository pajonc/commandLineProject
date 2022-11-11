package com.chrzanop.coding.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

/*
Input a non-empy input array of distinct integers and integer representing target sum
Result: function should find all triplets in the array that sum up to the target sum and return 2 dimensional array of all these triplets
the numbers in triplet should be ordered in asc order, and the triplets themselves should be ordered in asc order with respect
to the numbers they hold
Sum up to the target sum
 */


    // O(n2) time, O(n) space where n is number of input array
    public List<Integer[]> threeNumberSumSolution2(int[] array, int targetSum) {
        Arrays.sort(array);

        List<Integer[]> result = new ArrayList<Integer[]>();
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            int leftIdx = i + 1, rightIdx = array.length - 1;
            while (leftIdx < rightIdx) {
                int localSum = current + array[leftIdx] + array[rightIdx];
                if (localSum == targetSum) {
                    result.add(new Integer[]{current, array[leftIdx], array[rightIdx]});
                    leftIdx += 1;
                    rightIdx -= 1;
                } else if (localSum < targetSum) {
                    leftIdx += 1;
                } else {
                    rightIdx -= 1;
                }
            }
        }

        return result;
    }


    // O(n3) time, O(k) space where k is number of triplets
    public List<Integer[]> threeNumberSumSolution1(int[] array, int targetSum) {
        Arrays.sort(array);

        List<Integer[]> result = new ArrayList<Integer[]>();

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    int current = array[i] + array[j] + array[k];
                    if (current == targetSum) {
                        result.add(new Integer[]{array[i], array[j], array[k]});
                    }
                }
            }
        }

        return result;
    }

}
