package com.chrzanop.here;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {


    public static void main(String[] args) {

        int[] array1 = {9, 3, 4, 1};
        int[] array2 = {3, 4, 5, 1, 9};

        System.out.println("number by sorted " + findNumber(array1, array2));
        System.out.println("number by set " + findNumberBySet(array1, array2));

        int[] array1_2 = {5, 3, 4, 1};
        int[] array2_2 = {9, 3, 4, 5, 1};

        System.out.println("number by sorted " + findNumber(array1_2, array2_2));
        System.out.println("number by set " + findNumberBySet(array1_2, array2_2));

        int[] array1_3 = {5, 3, 4, 1, 9, 2};
        int[] array2_3 = {9, 3, 4, 5, 1};

        System.out.println("number by sorted " + findNumber(array1_3, array2_3));
        System.out.println("number by set " + findNumberBySet(array1_3, array2_3));

    }


    public static int findNumber(int[] arr1, int[] arr2) {
        int number = -1;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int lenght1 = arr1.length;
        int lenght2 = arr2.length;

        int subsetLenght = Math.min(lenght1, lenght2);

        boolean check = false;
        for (int i = 0; i < subsetLenght; i++) {
            if (arr1[i] != arr2[i]) {
                check = true;
                if (arr1.length > arr2.length) {
                    number = arr1[i];
                } else {
                    number = arr2[i];
                }
                break;
            }
        }

        if (!check) {
            if (arr1.length > arr2.length) {
                number = arr1[lenght1 - 1];
            } else {
                number = arr2[lenght2 - 1];
            }
        }
        return number;
    }


    public static int findNumberBySet(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();

        int[] biggerArray = arr2.length > arr1.length ? arr2 : arr1;
        int[] smallerArray = arr2.length < arr1.length ? arr2 : arr1;

        for (int i = 0; i < smallerArray.length; i++) {
            set.add(smallerArray[i]);
        }

        for (int i = 0; i < biggerArray.length; i++) {
            if (set.add(biggerArray[i])) {
                return biggerArray[i];
            }
        }

        return 0;


    }


}
