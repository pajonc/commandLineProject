package com.chrzanop.coding.algoexpert.arrays;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BestSeatTest {

    @Test
    public void TestCase1() {
        int[] input = new int[]{1, 0, 1, 0, 0, 0, 1};
        int expected = 4;
        int actual = new BestSeat().bestSeat_Mine(input);
        int actual2 = new BestSeat().bestSeat(input);
        assertTrue(expected == actual);
        assertTrue(expected == actual2);
    }

}