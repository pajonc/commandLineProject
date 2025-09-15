package com.chrzanop.coding.algoexpert.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterAreaTest {

    @Test
    public void TestCase1() {
        int[] input = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        assertTrue(WaterArea.waterArea(input) == 48);
    }

    @Test
    public void TestCase2() {
        int[] input = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        assertTrue(WaterArea.waterAreaAlgo1(input) == 48);
    }

    @Test
    public void TestCase3() {
        int[] input = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        assertTrue(WaterArea.waterAreaAlgo2(input) == 48);
    }
}