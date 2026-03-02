package com.chrzanop.coding.algoexpert.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnderscorifySubstringTest {

    @Test
    public void TestCase1() {
        String expected =
                "_test_this is a _testtest_ to see if _testestest_ it works";
        String output = UnderscorifySubstring.underscorifySubstring(
                "testthis is a testtest to see if testestest it works", "test"
        );
        assertTrue(expected.equals(output));
    }

}