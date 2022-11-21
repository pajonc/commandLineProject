package com.chrzanop.coding.algoexpert.arrays;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

/*
Given n array of integers between 1 to n, inclusive, where n is the length of the array,
write a function that returs the first integer that appears more than once
 */


public class FirstDuplicateValue {

    public static void main(String[] args) {
        FirstDuplicateValue fdValue = new FirstDuplicateValue();
        int[] input = new int[] {2, 1, 5, 2, 3, 3, 4};
        int expected = 2;
        int actual = fdValue.firstDuplicateValue(input);
        assertTrue(expected == actual);

        int[] input2 = new int[] {1, 2, 1};
        int expected2 = 1;
        int actual2  = fdValue.firstDuplicateValueSolution2(input2);
        assertTrue(expected2 == actual2);

    }


    // O(n) time | O(n) space
    public int firstDuplicateValue(int[] array) {
        Set<Integer> value = new HashSet<>();

        for(int i=0; i< array.length;i++) {
            if(value.contains(array[i])) {
                return array[i];
            } else {
                value.add(array[i]);
            }
        }

        return -1;
    }

    // O(n) time | O(1) space  --> IMPORTANT, VALUE IS WITH 1..n range, where n is lenght of the array,
    // additionally we can mutate the array
    public int firstDuplicateValueSolution2(int[] array) {

        // value - 1 = index
        for (int value : array) {
            int absValue = Math.abs(value);
            if (array[absValue - 1] < 0) return absValue;
            array[absValue - 1] *= -1;
        }

        return -1;
    }

}


