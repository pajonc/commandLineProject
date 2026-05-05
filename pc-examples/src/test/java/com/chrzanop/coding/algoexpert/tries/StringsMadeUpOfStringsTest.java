package com.chrzanop.coding.algoexpert.tries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsMadeUpOfStringsTest {

    @Test
    public void TestCase1() {
        String[] strings = new String[] {"bar", "are", "foo", "ba", "b", "barely"};
        String[] substrings = new String[] {"b", "a", "r", "ba", "ar", "bar"};
        String[] expected = new String[] {"bar", "ba", "b"};
        String[] actual = new StringsMadeUpOfStrings().stringsMadeUpOfStrings(strings, substrings);
        assertTrue(expected.length == actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertTrue(expected[i] == actual[i]);
        }
    }

}