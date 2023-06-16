package com.chrzanop.coding.algoexpert.dynamicprogramming;

import org.junit.Test;

import static com.chrzanop.coding.algoexpert.dynamicprogramming.NumberOfWaysToMakeChange.numberOfWaysToMakeChange;
import static org.junit.jupiter.api.Assertions.*;

public class NumberOfWaysToMakeChangeTest {

    @Test
    public void TestCase1() {
        int[] input = {1, 5};
        assertTrue(numberOfWaysToMakeChange(6, input) == 2);
    }

    @Test
    public void TestCase2() {
        int[] input = {1, 5, 10, 25};
        assertTrue(numberOfWaysToMakeChange(10, input) == 4);
    }


}