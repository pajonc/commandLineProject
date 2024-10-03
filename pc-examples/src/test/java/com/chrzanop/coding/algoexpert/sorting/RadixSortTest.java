package com.chrzanop.coding.algoexpert.sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RadixSortTest {

    @Test
    public void TestCase1() {
        ArrayList<Integer> input =
                new ArrayList(Arrays.asList(8762, 654, 3008, 345, 87, 65, 234, 12, 2));
        ArrayList<Integer> expected =
                new ArrayList(Arrays.asList(2, 12, 65, 87, 234, 345, 654, 3008, 8762));
        ArrayList<Integer> actual = new RadixSort().radixSort(input);
        assertTrue(expected.equals(actual));
    }

}