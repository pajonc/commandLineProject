package com.chrzanop.coding.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {

        MergeOverlappingIntervals moi = new MergeOverlappingIntervals();

        int[][] intervals =
                new int[][] {
                        {1, 2},
                        {3, 5},
                        {4, 7},
                        {6, 8},
                        {9, 10}
                };
        int[][] expected =
                new int[][] {
                        {1, 2},
                        {3, 8},
                        {9, 10}
                };
        int[][] actual = moi.mergeOverlappingIntervals(intervals);
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                assertTrue(expected[i][j] == actual[i][j]);
            }
        }


//        int[][] intervals = new int[2][2];
//        intervals[0][0] = 1;
//        intervals[0][1] = 2;
//        intervals[1][0] = 3;
//        intervals[1][1] = 4;
//        System.out.println(intervals[0][0]);

    }


    // O(nlogn) time due to sorting | O(n) space - if full array fullfilled in output
    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        // sort intervals by starting value
        int[][] sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedIntervals = new ArrayList<int[]>();
        int[] currentInterval = sortedIntervals[0];
        mergedIntervals.add(currentInterval);

        for (int[] nextInterval :  sortedIntervals) {
            int previousIntervalEnd = currentInterval[1];
            int nextIntervalStart = nextInterval[0];
            int nextIntervalEnd = nextInterval[1];

            if(previousIntervalEnd >= nextIntervalStart) {
                currentInterval[1] = Math.max(previousIntervalEnd, nextIntervalEnd);
            } else {
                currentInterval = nextInterval;
                mergedIntervals.add(currentInterval);
            }


        }

//        for (int i = 1; i < sortedIntervals.length; i++) {
//            int previousIntervalEnd = currentInterval[1];
//            int currentIntervalStart = sortedIntervals[i][0];
//            int currentIntervalEnd = sortedIntervals[i][1];
//
//            if (previousIntervalEnd >= currentIntervalStart) {
//                currentInterval[1] = Math.max(previousIntervalEnd, currentIntervalEnd);
//            } else {
//                currentInterval = sortedIntervals[i];
//                mergedIntervals.add(currentInterval);
//            }
//
//        }


        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
