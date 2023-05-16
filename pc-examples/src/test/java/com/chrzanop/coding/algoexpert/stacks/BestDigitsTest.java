package com.chrzanop.coding.algoexpert.stacks;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BestDigitsTest {

    @Test
    public void TestCase1() {
        String number = "462839";
        int numDigits = 2;
        String expected = "6839";
        String actual = new BestDigits().bestDigits(number, numDigits);
        assertTrue(expected.equals(actual));
    }

}