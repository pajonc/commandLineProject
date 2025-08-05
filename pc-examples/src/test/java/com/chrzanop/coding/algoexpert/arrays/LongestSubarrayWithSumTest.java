package com.chrzanop.coding.algoexpert.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubarrayWithSumTest {

    @Test
    public void TestCase1() {
        int[] array = new int[] {1, 2, 3, 4, 3, 3, 1, 2, 1};
        int targetSum = 10;
        int[] expected = new int[] {4, 8};
        var actual = new LongestSubarrayWithSum().longestSubarrayWithSum(array, targetSum);
        assertTrue(expected.length == actual.length);
        for (int i = 0; i < actual.length; i++) {
            assertTrue(actual[i] == expected[i]);
        }
    }
}