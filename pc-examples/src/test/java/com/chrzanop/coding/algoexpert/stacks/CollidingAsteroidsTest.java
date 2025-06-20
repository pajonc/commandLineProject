package com.chrzanop.coding.algoexpert.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollidingAsteroidsTest {

    @Test
    public void TestCase1() {
        int[] input = new int[]{-3, 5, -8, 6, 7, -4, -7};
        int[] expected = new int[]{-3, -8, 6};
        int[] actual = new CollidingAsteroids().collidingAsteroids(input);
        assertTrue(expected.length == actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertTrue(expected[i] == actual[i]);
        }
    }

    @Test
    public void TestCase2() {
        int[] input = new int[]{-3, 5, -8, 6, 7, -4, -7};
        int[] expected = new int[]{-3, -8, 6};
        int[] actual = new CollidingAsteroids().collidingAsteroidsAlgo(input);
        assertTrue(expected.length == actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertTrue(expected[i] == actual[i]);
        }
    }
}