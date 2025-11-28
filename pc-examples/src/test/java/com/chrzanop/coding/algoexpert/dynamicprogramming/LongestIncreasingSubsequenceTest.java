package com.chrzanop.coding.algoexpert.dynamicprogramming;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LongestIncreasingSubsequenceTest {

    @Test
    public void TestCase1() {
        int[] expected = {-24, 2, 3, 5, 6, 35};
        assertTrue(compare(
                LongestIncreasingSubsequence.longestIncreasingSubsequence(new int[] {
                        5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35}),
                expected
        ));
    }

    @Test
    public void TestCase2() {
        int[] expected = {-24, 2, 3, 5, 6, 35};
        assertTrue(compare(
                LongestIncreasingSubsequence.longestIncreasingSubsequence1(new int[] {
                        5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35}),
                expected
        ));
    }

    public static boolean compare(List<Integer> arr1, int[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}