package com.chrzanop.coding.algoexpert.greedy;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TandemBicycleTest {

    @Test
    public void TestCase1() {
        int[] redShirtSpeeds = new int[]{5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = new int[]{3, 6, 7, 2, 1};
        boolean fastest = true;
        int expected = 32;
        int actual = new TandemBicycle().tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest);
        assertTrue(expected == actual);
    }
}