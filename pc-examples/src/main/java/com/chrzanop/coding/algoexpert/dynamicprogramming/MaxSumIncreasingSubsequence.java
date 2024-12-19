package com.chrzanop.coding.algoexpert.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxSumIncreasingSubsequence {


    // O(n^2) time | O(n) space
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {

        int[] sums = new int[array.length];
        int[] sequences = new int[array.length];
        for (int i = 0; i < sequences.length; i++) {
            sequences[i] = -1;
        }
        int maxSum = array[0];
        sums[0]=array[0];
        int indexOfMaxSum=0;
        for (int i = 1; i < array.length; i++) {
            sums[i] = array[i];
            for (int j = 0; j < i; j++) {
                if(array[j]<array[i] && sums[i] < sums[j] + array[i]) {
                    sums[i] = sums[j]+array[i];
                    sequences[i]=j;
                }
            }
            if(maxSum<sums[i]) {
                maxSum = sums[i];
                indexOfMaxSum = i;
            }
        }
        final int maximum = maxSum;
        List<Integer> maxSequence = new ArrayList<>();
        maxSequence.add(array[indexOfMaxSum]);
        int k = indexOfMaxSum;
        while(k>=0) {
            if(sequences[k] != -1) {
                maxSequence.add(array[sequences[k]]);
                k = sequences[k];
                continue;
            }
            break;
        }
        
        Collections.reverse(maxSequence);

        return new ArrayList<List<Integer>>() {
            {
                add(List.of(maximum)); // Example max sum
                add(maxSequence); // Example max sequence
            }
        };
    }
}
