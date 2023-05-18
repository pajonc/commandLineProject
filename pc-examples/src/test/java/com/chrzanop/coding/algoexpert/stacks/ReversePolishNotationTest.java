package com.chrzanop.coding.algoexpert.stacks;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReversePolishNotationTest {

    @Test
    public void TestCase1() {
        String[] input = new String[]{"3", "2", "+", "7", "*"};
        int expected = 35;
        int actual = new ReversePolishNotation().reversePolishNotation(input);
        assertTrue(expected == actual);
    }

}