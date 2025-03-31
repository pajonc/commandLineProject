package com.chrzanop.coding.algoexpert.tries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortestUniquePrefixesTest {

    @Test
    public void TestCase1() {
        String[] strings =
                new String[] {"algoexpert", "algorithm", "frontendexpert", "mlexpert"};
        String[] expected = new String[] {"algoe", "algor", "f", "m"};
        String[] actual = new ShortestUniquePrefixes().shortestUniquePrefixes(strings);
        assertTrue(expected.length == actual.length);
        for (int idx = 0; idx < expected.length; idx++) {
            assertTrue(expected[idx].equals(actual[idx]));
        }
    }


}