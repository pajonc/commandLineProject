package com.chrzanop.coding.algoexpert.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightConnectionTest {

    @Test
    public void TestCase1() {
        var knightA = new int[] {0, 0};
        var knightB = new int[] {2, 1};
        var expected = 1;
        var actual = new KnightConnection().knightConnection(knightA, knightB);
        assertTrue(expected == actual);
    }

}