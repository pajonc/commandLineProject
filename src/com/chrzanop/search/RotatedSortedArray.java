package com.chrzanop.search;

public class RotatedSortedArray {

    public static void main(String[] args) {
        int[] originalArray = {0, 1, 2, 4, 5, 6, 7};
        int[] rotatedSortedArray = {4, 5, 6, 7, 0, 1, 2};

        System.out.println(findPivot(rotatedSortedArray));
        System.out.println(findPivot(rotatedSortedArray, 0, rotatedSortedArray.length - 1));

        System.out.println(indexOfTarget(rotatedSortedArray, 7));
    }

    public static int findPivot(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static int findPivot(int[] array, int left, int right) {

        if (left == right) {
            return left;
        }

        int mid = left + (right - left) / 2;
        if (array[mid] > array[right]) {
            left = mid + 1;
        } else {
            right = mid;
        }
        return findPivot(array, left, right);

    }


    public static int indexOfTarget(int[] rotatedArray, int target) {

        int pivot = findPivot(rotatedArray);
        int left = 0;
        int right = rotatedArray.length - 1;

        if (target >= rotatedArray[pivot] && target <= rotatedArray[right]) {
            left = pivot;
        } else {
            right = pivot;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (rotatedArray[mid] == target) {
                return mid;
            } else if (rotatedArray[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }

        }
        return -1;
    }

}
