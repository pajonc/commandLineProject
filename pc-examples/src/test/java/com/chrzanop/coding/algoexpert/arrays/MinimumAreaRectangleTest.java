package com.chrzanop.coding.algoexpert.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumAreaRectangleTest {

    @Test
    public void TestCase1() {
        int[][] input = new int[][] {
                {1, 5}, {5, 1}, {4, 2}, {2, 4}, {2, 2}, {1, 2}, {4, 5}, {2, 5}, {-1, -2}};
        int expected = 3;
        var actual = new MinimumAreaRectangle().minimumAreaRectangle(input);
        assertTrue(expected == actual);
    }

    @Test
    public void TestCase2() {
        int[][] input = new int[][] {
                {1, 5}, {5, 1}, {4, 2}, {2, 4}, {2, 2}, {1, 2}, {4, 5}, {2, 5}, {-1, -2}};
        int expected = 3;
        var actual = new MinimumAreaRectangle().minimumAreaRectangleAlgo(input);
        assertTrue(expected == actual);
    }


}