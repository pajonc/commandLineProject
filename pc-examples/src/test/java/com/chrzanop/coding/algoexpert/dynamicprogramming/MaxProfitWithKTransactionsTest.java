package com.chrzanop.coding.algoexpert.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxProfitWithKTransactionsTest {

    @Test
    public void TestCase1() {
        int[] input = {5, 11, 3, 50, 60, 90};
        assertTrue(MaxProfitWithKTransactions.maxProfitWithKTransactions(input, 2) == 93);
    }

}