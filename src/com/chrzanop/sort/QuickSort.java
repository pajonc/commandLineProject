package com.chrzanop.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {6, 1, 8, 4, 5, 2, 7, 3, 9};

        sort(array, 0, array.length - 1);

        System.out.println("-----------");
    }

    public static final void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = left + (right - left) / 2;
        int a = left, b = left;
        swapArray(array, pivot, right);

        while (a < right) {
            if (array[a] < array[right]) {
                swapArray(array, a, b);
                b++;
            }
            a++;
        }

        if (b != right) {
            swapArray(array, b, right);
        }

        sort(array, left, b - 1);
        sort(array, b + 1, right);
    }


    private static final void swapArray(int[] array, int indexSwapA, int indexSwapB) {
        if (indexSwapA > array.length || indexSwapB > array.length)
            return;
        int copyValueA = array[indexSwapA];
        int copyValueB = array[indexSwapB];
        array[indexSwapA] = copyValueB;
        array[indexSwapB] = copyValueA;
    }
}
