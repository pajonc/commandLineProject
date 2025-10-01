package com.chrzanop.coding.algoexpert.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersInPiTest {

    String PI = "3141592653589793238462643383279";
    String PI_2 = "3141592";
    @Test
    public void TestCase1() {
        String[] numbers = new String[] {
                "314159265358979323846",
                "26433",
                "8",
                "3279",
                "314159265",
                "35897932384626433832",
                "79"};
        assertTrue(NumbersInPi.numbersInPi(PI, numbers) == 2);
    }


    @Test
    public void TestCase2() {
        String[] numbers = new String[] {
                "3141",
                "5",
                "31",
                "2",
                "4159",
                "9",
                "42"};
        assertTrue(NumbersInPi.numbersInPiOptimal(PI_2, numbers) == 2);
    }

    @Test
    public void TestCase3() {
        String[] numbers = new String[] {
                "3141",
                "5",
                "31",
                "2",
                "4159",
                "9",
                "42"};
        assertTrue(NumbersInPi.numbersInPi(PI_2, numbers) == 2);
    }

}