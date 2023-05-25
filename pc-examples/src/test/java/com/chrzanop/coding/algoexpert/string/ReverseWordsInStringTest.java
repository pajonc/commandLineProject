package com.chrzanop.coding.algoexpert.string;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ReverseWordsInStringTest {

    @Test
    public void TestCase1() {
        String input = "AlgoExpert is the best!";
        String expected = "best! the is AlgoExpert";
        String actual = new ReverseWordsInString().reverseWordsInString(input);
        String actual2 = new ReverseWordsInString().reverseWordsInString_Algo1(input);
        String actual3 = new ReverseWordsInString().reverseWordsInString_Algo2(input);
        assertTrue(expected.equals(actual));
        assertTrue(expected.equals(actual2));
        assertTrue(expected.equals(actual3));
    }

}