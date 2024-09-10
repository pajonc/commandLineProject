package com.chrzanop.coding.algoexpert.sorting;

public class HeapSort {

    // O (nlog(n)) time | O(1) space
    public static int[] heapSort(int[] array) {
        buildMaxHeap(array);
        int endIdx = array.length-1;
        while(endIdx>0) {
            swap(0, endIdx, array);
            endIdx = endIdx - 1;
            siftDown(0, endIdx, array);
        }
        return array;
    }

    private static void buildMaxHeap(int[] array) {
        int parentIdx = (array.length - 1) / 2;
        for (int i = parentIdx; i >=0 ; i--) {
            siftDown(i, array.length-1, array);
        }
    }

    private static void siftDown(int currentIdx, int endIdx, int[] array) {
        int childFirstIdx = 2 * currentIdx + 1;
        while (childFirstIdx <= endIdx) {
            int childTwoIdx = 2 * currentIdx + 2;
            int idxToSwap = childFirstIdx;
            if (childTwoIdx <= endIdx && array[childTwoIdx] > array[childFirstIdx]) {
                idxToSwap = childTwoIdx;
            }
            if (array[currentIdx] < array[idxToSwap]) {
                swap(currentIdx, idxToSwap, array);
                currentIdx = idxToSwap;
                childFirstIdx = 2 * currentIdx + 1;
            } else {
                break;
            }
        }
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
