package com.chrzanop.coding.algoexpert.sorting;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ThreeNumberSort {


    @Test
    public void TestCase1() {
        int[] array = new int[]{1, 0, 0, -1, -1, 0, 1, 1};
        int[] order = new int[]{0, 1, -1};
        int[] expected = new int[]{0, 0, 0, 1, 1, 1, -1, -1};
        ThreeNumberSort tns = new ThreeNumberSort();
        int[] actual = tns.threeNumberSort(array, order);
        assertTrue(expected.length == actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertTrue(expected[i] == actual[i]);
        }
    }


    public int[] threeNumberSortAlgo1(int[] array, int[] order) {
        int[] valueCounts = new int[]{0, 0, 0};

        for (int element : array) {
            int orderIdx = getIndex(order, element);
            valueCounts[orderIdx] += 1;
        }

        for (int i = 0; i < order.length; i++) {
            int value = order[i];
            int count = valueCounts[i];

            int numElementsBefore = getSum(valueCounts, i);
            for (int n = 0; n < count; n++) {
                int currentIdx = numElementsBefore + n;
                array[currentIdx] = value;
            }
        }
        return array;
    }

    private int getIndex(int[] order, int element) {
        for (int i = 0; i < order.length; i++) {
            if (order[i] == element) {
                return i;
            }
        }
        return -1;
    }

    private int getSum(int[] array, int end) {
        int sum = 0;
        for (int i = 0; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }


    public int[] threeNumberSortAlgo2(int[] array, int[] order) {
        // sort first from order
        int idx = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == order[0]) {
                swap(array, i, idx);
                idx += 1;
            }
        }
        // sort last from order
        idx = array.length - 1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == order[2]) {
                swap(array, i, idx);
                idx -= 1;
            }
        }
        return array;
    }


    public int[] threeNumberSortAlgo3(int[] array, int[] order) {

        int firstIdx = 0;
        int secondIdx = 0;
        int lastIdx = array.length - 1;

        while (secondIdx <= lastIdx) {

            int value = array[secondIdx];
            if (value == order[0]) {
                swap(array, firstIdx, secondIdx);
                firstIdx++;
                secondIdx++;
            } else if (value == order[1]) {
                secondIdx++;
            } else if (value == order[2]) {
                swap(array, secondIdx, lastIdx);
                lastIdx--;
            }

        }

        return array;
    }

    public int[] threeNumberSort(int[] array, int[] order) {
        int first = 0, second = 0, third = 0;
        int orderFirst = order[0];
        int orderSecond = order[1];
        int orderThird = order[2];

        for (int i = 0; i < array.length; i++) {
            if (array[i] == orderFirst) {
                first += 1;
            } else if (array[i] == orderSecond) {
                second += 1;
            } else if (array[i] == orderThird) {
                third += 1;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (first > 0) {
                swap1(array, i, orderFirst);
                first--;
            } else if (second > 0) {
                swap1(array, i, orderSecond);
                second--;
            } else if (third > 0) {
                swap1(array, i, orderThird);
                third--;
            }
        }

        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    private void swap1(int[] array, int i, int element) {
        array[i] = element;
    }
}
