package com.chrzanop.coding.algoexpert.dynamicprogramming;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinNumberOfCoinsForChangeTest {

    @Test
    public void TestCase1() {
        int[] input = {1, 5, 10};
        assertTrue(MinNumberOfCoinsForChange.minNumberOfCoinsForChange_Mine(7, input) == 3);
    }

    @Test
    public void TestCase2() {
        int[] input = {1, 5, 10};
        assertTrue(MinNumberOfCoinsForChange.minNumberOfCoinsForChange(7, input) == 3);
    }

}