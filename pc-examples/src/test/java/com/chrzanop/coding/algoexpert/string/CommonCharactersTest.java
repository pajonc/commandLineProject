package com.chrzanop.coding.algoexpert.string;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CommonCharactersTest {

    @Test
    public void TestCase1() {
        String[] input = new String[] {"abc", "bcd", "cbad"};
        String[] expected = new String[] {"b", "c"};
        String[] actual = new CommonCharacters().commonCharacters_Algo1(input);
        String[] actual2 = new CommonCharacters().commonCharacters_Algo2(input);
        Arrays.sort(actual);
        Arrays.sort(actual2);
        assertTrue(expected.length == actual.length);
        for (int i = 0; i < actual.length; i++) {
            assertTrue(expected[i].equals(actual[i]));
            assertTrue(expected[i].equals(actual2[i]));
        }
    }

}