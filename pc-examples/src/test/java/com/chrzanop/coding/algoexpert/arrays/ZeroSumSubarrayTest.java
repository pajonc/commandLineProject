package com.chrzanop.coding.algoexpert.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ZeroSumSubarrayTest {

    @Test
    void shouldPassTestCase() {
        ZeroSumSubarray zeroSumSubarray = new ZeroSumSubarray();
        int[] nums = new int[]{4, 2, -1, -1, 3};
        assertTrue(zeroSumSubarray.zeroSumSubarray(nums));
    }
}