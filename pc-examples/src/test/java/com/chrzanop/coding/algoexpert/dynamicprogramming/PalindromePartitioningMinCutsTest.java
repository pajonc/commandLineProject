package com.chrzanop.coding.algoexpert.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromePartitioningMinCutsTest {

    @Test
    public void TestCase1() {
        assertTrue(PalindromePartitioningMinCuts.palindromePartitioningMinCuts("noonabbad") == 2);
    }

}