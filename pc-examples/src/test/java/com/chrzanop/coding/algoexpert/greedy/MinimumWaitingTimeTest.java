package com.chrzanop.coding.algoexpert.greedy;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinimumWaitingTimeTest {

    @Test
    public void TestCase1() {
        int[] queries = new int[] {3, 2, 1, 2, 6};
        int expected = 17;
        int actual = new MinimumWaitingTime().minimumWaitingTime(queries);
        assertTrue(actual == expected);
    }

}