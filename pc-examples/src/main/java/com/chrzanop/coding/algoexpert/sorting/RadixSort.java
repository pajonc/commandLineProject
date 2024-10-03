package com.chrzanop.coding.algoexpert.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class RadixSort {

    /*
    O(d*(n+b)) time | O(n+b) space where n is the length of the input
    array, d is the max number of digits, and b is the base of the numbering system used (binary 2, decimal 10, hex 16 etc.)
     */
    public ArrayList<Integer> radixSort(ArrayList<Integer> array) {
        if (array.size() == 0) {
            return array;
        }

        int maxNumber = Collections.max(array);
        int digit = 0;
        while ((maxNumber / Math.pow(10, digit)) > 0) {
            countingSort(array, digit);
            digit += 1;
        }
        return array;
    }

    private void countingSort(ArrayList<Integer> array, int digit) {
        int[] countArray = new int[10];
        int[] sortedArray = new int[array.size()];

        int digitColumn = (int) Math.pow(10, digit);
        for (Integer num : array) {
            int countIdx = (num / digitColumn) % 10;
            countArray[countIdx] += 1;
        }

        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        for (int i = array.size() - 1; i >= 0; i--) {
            int digitAt = (array.get(i) / digitColumn) % 10;
            countArray[digitAt] -= 1;
            int sortedIndex = countArray[digitAt];
            sortedArray[sortedIndex] = array.get(i);
        }

        for (int i = 0; i < array.size(); i++) {
            array.set(i, sortedArray[i]);
        }

    }

}
