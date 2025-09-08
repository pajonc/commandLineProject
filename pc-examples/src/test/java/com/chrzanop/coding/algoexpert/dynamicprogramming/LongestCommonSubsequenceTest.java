package com.chrzanop.coding.algoexpert.dynamicprogramming;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubsequenceTest {

    @Test
    public void TestCase1() {
        char[] expected = {'X', 'Y', 'Z', 'W'};
        List<Character> actual = LongestCommonSubsequence.longestCommonSubsequence("ZXVVYZW", "XKYKZPW");
//        assertArrayEquals(actual, expected);
        assertTrue(
                compare(actual, expected)
        );
    }

    @Test
    public void TestCase2() {
        char[] expected = {'X', 'Y', 'Z', 'W'};
        List<Character> actual = LongestCommonSubsequence.longestCommonSubsequenceAlgoSimilar("ZXVVYZW", "XKYKZPW");
//        assertArrayEquals(actual, expected);
        assertTrue(
                compare(actual, expected)
        );
    }

    @Test
    public void TestCase3() {
        char[] expected = {'X', 'Y', 'Z', 'W'};
        List<Character> actual = LongestCommonSubsequence.longestCommonSubsequenceAlgo1("ZXVVYZW", "XKYKZPW");
//        assertArrayEquals(actual, expected);
        assertTrue(
                compare(actual, expected)
        );
    }

    private static boolean compare(List<Character> arr1, char[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != arr2[i]) {
                return false;
            }
        }
        return true;
    }



}