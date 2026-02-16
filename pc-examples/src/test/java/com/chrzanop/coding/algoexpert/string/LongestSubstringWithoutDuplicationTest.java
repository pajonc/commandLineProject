package com.chrzanop.coding.algoexpert.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutDuplicationTest {

    @Test
    public void TestCase1() {
        String result = LongestSubstringWithoutDuplication.longestSubstringWithoutDuplication("clementisacap");
        System.out.println(result);
        assertTrue(result
                .equals("mentisac"));
    }

}