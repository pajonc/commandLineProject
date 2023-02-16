package com.chrzanop.coding.algoexpert.searching;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FindThreeLargestNumbers {


    @Test
    public void TestCase1() {
        int[] expected = {18, 141, 541};
        int[] actual = findThreeLargestNumbers(new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7});
        assertTrue(
                compare(
                        actual,
                        expected));
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


    public static int[] findThreeLargestNumbers(int[] array) {
        int[] result = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int i = 0; i < array.length; i++) {

            checkAndShift(array[i], result);

        }
        return result;
    }

    private static void checkAndShift(int element, int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < element) {
                applyShifting(element, i, arr);
                break;
            }
        }
    }

    private static void applyShifting(int element, int idx, int[] arr) {

        for (int i = idx; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = element;
            element = temp;
        }

    }


}
