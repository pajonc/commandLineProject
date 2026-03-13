package com.chrzanop.coding.algoexpert.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountSquaresTest {

    @Test
    public void TestCase1() {
        var input = new int[][] {
                new int[] {1, 1}, new int[] {0, 0}, new int[] {0, 1}, new int[] {1, 0}};
        var expected = 1;
        var actual = new CountSquares().countSquares(input);
        assertTrue(expected == actual);
    }

}