package com.chrzanop.coding.algoexpert.arrays;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonotonicArrayTest {

    private MonotonicArray monotonicArray = new MonotonicArray();

    @Test
    public void shouldPassTestCase1() {
        int[] array = new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        boolean expected = true;
        boolean actual = monotonicArray.isMonotonic(array);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPassTestSolution2() {
        int[] array = new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        int[] array2 = new int[]{1, 2, -1, -2, -5};
        int[] array3 = new int[]{1, 1, 1, 2, 3, 4, 1};
        int[] array4 = new int[]{-1, -1, -1, 0};
        boolean expected = true;
        boolean actual = monotonicArray.isMonotonicSolution2(array);
        boolean actual2 = monotonicArray.isMonotonicSolution2(array2);
        boolean actual3 = monotonicArray.isMonotonicSolution2(array3);
        boolean actual4 = monotonicArray.isMonotonicSolution2(array4);
        assertEquals(expected, actual);
        assertEquals(false, actual2);
        assertEquals(false, actual3);
        assertEquals(true, actual4);
    }


}