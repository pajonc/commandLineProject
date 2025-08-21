package com.chrzanop.coding.algoexpert.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinNumberOfJumpsTest {

    @Test
    public void TestCase1() {
        int[] input = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};
        assertTrue(MinNumberOfJumps.minNumberOfJumps(input) == 4);
    }

    @Test
    public void TestCase2() {
        int[] input = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};
        assertTrue(MinNumberOfJumps.minNumberOfJumps2(input) == 4);
    }

}