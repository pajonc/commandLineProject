package com.chrzanop.coding.algoexpert.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissingNumbersTest {

    @Test
    public void TestCase1() {
        var input = new int[] {4, 5, 1, 3};
        var expected = new int[] {2, 6};
        var actual = new MissingNumbers().missingNumbers(input);
        assertTrue(expected.length == actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertTrue(expected[i] == actual[i]);
        }
    }

}