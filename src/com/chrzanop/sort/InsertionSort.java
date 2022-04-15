package com.chrzanop.sort;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {2, 8, 5, 3, 9, 4, 1};

        sort2(array);
        System.out.println(array);
    }

    public static int[] sort(int[] array) {

        int k, j;
        for (int i = 0; i < array.length; i++) {
            k = i + 1;
            j = i;
            while (j >= 0 && k < array.length) {
                if (array[j] > array[k]) {
                    swap(array, j, k);
                }
                k--;
                j--;
            }
        }
        return array;
    }

    public static int[] sort2(int[] array) {
        int j;
        for (int i = 1; i < array.length ; i++) {
            j = i;
            while (j > 0 && array[j - 1] > array[j]) {
                swap(array, j - 1, j);
                j--;
            }
        }
        return array;
    }


    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
