package com.chrzanop.coding.algoexpert.dynamicprogramming;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaxSubsetSumNoAdjacentTest {

    @Test
    public void TestCase1() {
        int[] input = {75, 105, 120, 75, 90, 135};
        assertTrue(MaxSubsetSumNoAdjacent.maxSubsetSumNoAdjacent(input) == 330);
    }

}