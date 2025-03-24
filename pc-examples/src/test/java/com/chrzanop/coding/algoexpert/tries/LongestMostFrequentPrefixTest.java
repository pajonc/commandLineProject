package com.chrzanop.coding.algoexpert.tries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestMostFrequentPrefixTest {

    @Test
    public void TestCase1() {
        String[] strings =
                new String[] {"algoexpert", "algorithm", "frontendexpert", "mlexpert"};
        String expected = "algo";
        String actual = new LongestMostFrequentPrefix().longestMostFrequentPrefix(strings);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void TestCase2() {
        String[] strings =
                new String[] {"baz", "foo","hello","foods","back"};
        String expected = "foo";
        String actual = new LongestMostFrequentPrefix().longestMostFrequentPrefix(strings);
        assertTrue(expected.equals(actual));
    }

}