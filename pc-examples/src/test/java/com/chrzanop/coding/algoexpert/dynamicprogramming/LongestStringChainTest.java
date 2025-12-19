package com.chrzanop.coding.algoexpert.dynamicprogramming;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LongestStringChainTest {

    @Test
    public void TestCase1() {
        List<String> strings = new ArrayList<String>(Arrays.asList(
                "abde", "abc", "abd", "abcde", "ade", "ae", "1abde", "abcdef"
        ));
        List<String> expected = new ArrayList<String>(
                Arrays.asList("abcdef", "abcde", "abde", "ade", "ae")
        );
        assertTrue(LongestStringChain.longestStringChain(strings).equals(expected));
    }

}