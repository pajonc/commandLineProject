package com.chrzanop.coding.algoexpert.string;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class MinimumCharactersForWordsTest {

    @Test
    public void TestCase1() {
        String[] words = new String[]{"this", "that", "did", "deed", "them!", "a"};
        char[] expected = new char[]{'t', 't', 'h', 'i', 's', 'a', 'd', 'd', 'e', 'e', 'm', '!'};
        char[] actual = new MinimumCharactersForWords().minimumCharactersForWords(words);
        Arrays.sort(expected);
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void TestCase2() {
        String[] words = new String[]{"this", "that", "did", "them!", "a"};
        char[] expected = new char[]{'t', 't', 'h', 'i', 's', 'a', 'd', 'd', 'e', 'm', '!'};
        char[] actual = new MinimumCharactersForWords().minimumCharactersForWords(words);
        Arrays.sort(expected);
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

}