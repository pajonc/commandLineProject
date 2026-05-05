package com.chrzanop.coding.algoexpert.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterfallStreamsTest {

    @Test
    public void TestCase1() {
        double[][] array = new double[][] {
                {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                {1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                {0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0},
                {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                {1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0},
                {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0},
                {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
        };
        var source = 3;
        double[] expected = {0.0, 0.0, 0.0, 25.0, 25.0, 0.0, 0.0};
        double[] actual = new WaterfallStreams().waterfallStreams(array, source);
        assertTrue(expected.length == actual.length);
        for (int i = 0; i < expected.length; i++)
            assertTrue(expected[i] == actual[i]);
    }

}