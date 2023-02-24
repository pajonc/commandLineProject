package com.chrzanop.coding.algoexpert.sorting;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SelectionSort {

    public static int[] selectionSort(int[] array) {
        if(array.length == 0) {
            return new int[] {};
        }
        int startIdx = 0;
        while(startIdx<array.length-1) {
            int smallestIdx = startIdx;
            for(int i=startIdx + 1;i<array.length;i++){
                if(array[smallestIdx]>array[i]){
                    smallestIdx = i;
                }
            }
            swap(startIdx, smallestIdx, array);
            startIdx++;
        }
        return array;
    }

    private static void swap(int i, int j, int[] array){
        if(i==j) return;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Test
    public void TestCase1() {
        int[] expected = {2, 3, 5, 5, 6, 8, 9};
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        assertTrue(compare(selectionSort(input), expected));
    }

    public boolean compare(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}
