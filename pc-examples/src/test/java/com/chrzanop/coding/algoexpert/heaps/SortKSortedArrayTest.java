package com.chrzanop.coding.algoexpert.heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortKSortedArrayTest {

    @Test
    void shouldPass() {
        int[] input = new int[] {3, 2, 1, 5, 4, 7, 6, 5};
        int k = 3;
        int[] expected = new int[] {1, 2, 3, 4, 5, 5, 6, 7};
        int[]  actual = new SortKSortedArray().sortKSortedArray(input, k);
        for (int i = 0; i < expected.length; i++) {
            assertTrue(expected[i] == actual[i]);
        }
    }

}