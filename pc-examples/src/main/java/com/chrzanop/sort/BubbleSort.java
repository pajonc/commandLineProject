package com.chrzanop.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {2, 8, 5, 3, 9, 4, 1};

        sort(array);
        System.out.println(array);
    }

    public static int[] sort(int[] array) {


        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
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
