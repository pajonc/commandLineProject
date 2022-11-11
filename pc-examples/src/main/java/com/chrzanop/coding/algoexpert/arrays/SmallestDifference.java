package com.chrzanop.coding.algoexpert.arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class SmallestDifference {

    // O(nlogn + n2 + logn) -> so n2 time | O(n) space
    public static int[] smallestDifferenceSolution1(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayTwo); // nlogn

        TreeMap<Integer, Integer[]> map = new TreeMap<>();

        for (int i = 0; i < arrayOne.length; i++) { // -> n2
            int currentOne = arrayOne[i];
            int currentTwo = arrayTwo[0];
            int firstDiffAbs = Math.abs(currentOne - currentTwo);
            int nextDiffAbs = 0;

            for (int j = 1; j < arrayTwo.length; j++) {
                nextDiffAbs = Math.abs(currentOne - arrayTwo[j]);
                if (nextDiffAbs < firstDiffAbs) {
                    firstDiffAbs = nextDiffAbs;
                    currentTwo = arrayTwo[j];
                } else {
                    break;
                }
            }
            map.put(firstDiffAbs, new Integer[]{currentOne, currentTwo});  // -> logn
        }

        Map.Entry<Integer, Integer[]> firstEntry = map.firstEntry();
        Integer[] entryValue = firstEntry.getValue();
        return new int[]{entryValue[0], entryValue[1]};

    }

    // O(nlogn) + O(mlogm) time | O(1) space
    public static int[] smallestDifferenceSolution2(int[] arrayOne, int[] arrayTwo) {

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int idxOne = 0, idxTwo = 0;
        int val1 = 0, val2 = 0, res1 = 0, res2 = 0;
        int minAbs = Math.abs(arrayOne[0] - arrayTwo[0]);

        while (idxOne < arrayOne.length && idxTwo < arrayTwo.length) {
            val1 = arrayOne[idxOne];
            val2 = arrayTwo[idxTwo];
            int diffAbs = Math.abs(val1 - val2);
            if (diffAbs == 0) {
                res1 = val1;
                res2 = val2;
                break;
            }

            if (diffAbs < minAbs) {
                minAbs = diffAbs;
                res1 = val1;
                res2 = val2;
            }

            if (val1 < val2) {
                idxOne += 1;
            } else {
                idxTwo += 1;
            }
        }


        return new int[]{res1, res2};
    }

}
