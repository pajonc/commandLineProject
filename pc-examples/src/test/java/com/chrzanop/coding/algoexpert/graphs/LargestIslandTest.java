package com.chrzanop.coding.algoexpert.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestIslandTest {

    @Test
    public void TestCase1() {
        var input = new int[][] {{0, 1, 1}, {0, 0, 1}, {1, 1, 0}};
        var expected = 5;
        var actual = new LargestIsland().largestIsland(input);
        assertTrue(expected == actual);
    }

    @Test
    public void TestCase2() {
        var input = new int[][] {{0, 1, 1}, {0, 0, 1}, {1, 1, 0}};
        var expected = 5;
        var actual = new LargestIsland().largestIslandAlgo2(input);
        assertTrue(expected == actual);
    }

}