package com.chrzanop.search;

public class BinarySearch {

    public static boolean binarySearchRecursive(int[] array, int x, int left, int right) {
        if (left > right) {
            return false;
        }
        int mid = left + (right - left) / 2;
        if (array[mid] == x) {
            return true;
        } else if (array[mid] > x) {
            right = mid - 1;
            return binarySearchRecursive(array, x, left, right);
        } else {
            left = mid + 1;
            return binarySearchRecursive(array, x, left, right);
        }
    }

    public static boolean binarySearchRecursive(int[] array, int x) {
        return binarySearchRecursive(array, x, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 7, 12, 16, 19, 33, 55, 88, 91, 103};

        boolean exist = binarySearchRecursive(array, 7);
        System.out.println(exist);

    }


}
