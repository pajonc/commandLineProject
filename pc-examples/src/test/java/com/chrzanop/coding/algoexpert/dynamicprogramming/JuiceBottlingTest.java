package com.chrzanop.coding.algoexpert.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JuiceBottlingTest {

    @Test
    public void TestCase1() {
        var input = new int[] {0, 2, 5, 6};
        var expected = new int[] {1, 2};
        var actual = new JuiceBottling().juiceBottling(input);
        assertTrue(expected.length == actual.size());
        for (int i = 0; i < actual.size(); i++) {
            assertTrue(expected[i] == actual.get(i));
        }
    }

    @Test
    public void TestCase2() {
        var input = new int[] {0, 2, 5, 6};
        var expected = new int[] {1, 2};
        var actual = new JuiceBottling().juiceBottlingAlgo1Try(input);
        assertTrue(expected.length == actual.size());
        for (int i = 0; i < actual.size(); i++) {
            assertTrue(expected[i] == actual.get(i));
        }
    }

    @Test
    public void TestCase3() {
        var input = new int[] {0, 2, 5, 6};
        var expected = new int[] {1, 2};
        var actual = new JuiceBottling().juiceBottlingAlgo1(input);
        assertTrue(expected.length == actual.size());
        for (int i = 0; i < actual.size(); i++) {
            assertTrue(expected[i] == actual.get(i));
        }
    }

    @Test
    public void TestCase4() {
        var input = new int[] {0, 2, 3, 4};
        var expected = new int[] {1, 1, 1};
        var actual = new JuiceBottling().juiceBottlingAlgo1(input);
        assertTrue(expected.length == actual.size());
        for (int i = 0; i < actual.size(); i++) {
            assertTrue(expected[i] == actual.get(i));
        }
    }


    @Test
    public void TestCase5() {
        var input = new int[] {0, 2, 5, 6, 7};
        var expected = new int[] {2,2};
        var actual = new JuiceBottling().juiceBottlingAlgo1(input);
        assertTrue(expected.length == actual.size());
        for (int i = 0; i < actual.size(); i++) {
            assertTrue(expected[i] == actual.get(i));
        }
    }



}