package com.chrzanop.coding.algoexpert.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallestSubstringContainingTest {

    @Test
    public void TestCase1() {
        String bigString = "abcd$ef$axb$c$";
        String smallString = "$$abf";
        String expected = "f$axb$";
        assertTrue(SmallestSubstringContaining.smallestSubstringContaining(bigString, smallString)
                .equals(expected));
    }

}