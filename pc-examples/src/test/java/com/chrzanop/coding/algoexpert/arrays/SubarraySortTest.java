package com.chrzanop.coding.algoexpert.arrays;

import org.junit.Test;

import java.util.Arrays;

import static com.chrzanop.coding.algoexpert.arrays.SubarraySort.subarraySort;
import static org.junit.jupiter.api.Assertions.*;

public class SubarraySortTest {

    @Test
    public void shouldPassTestCase() {
        int[] expected = {3, 9};
        assertTrue(
                Arrays.equals(
                        subarraySort(new int[] {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19}),
                        expected));
    }

    @Test
    public void shouldPassTestCase2() {
        int[] expected = {0, 6};
        int[] result = subarraySort(new int[]{1, 2, 4, 16, 18, 19, -1});
        assertTrue(
                Arrays.equals(
                        result,
                        expected));
    }

    @Test
    public void shouldPassTestCase3() {
        int[] expected = {-1, -1};
        int[] result = subarraySort(new int[]{1, 2, 4, 16, 18, 19, 20});
        assertTrue(
                Arrays.equals(
                        result,
                        expected));
    }




}