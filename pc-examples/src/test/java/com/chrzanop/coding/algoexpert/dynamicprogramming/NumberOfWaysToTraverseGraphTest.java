package com.chrzanop.coding.algoexpert.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfWaysToTraverseGraphTest {


    @Test
    public void TestCase1() {
        int width = 4;
        int height = 3;
        int expected = 10;
        var actual = NumberOfWaysToTraverseGraph.numberOfWaysToTraverseGraph(width, height);
        assertTrue(expected == actual);
    }

    @Test
    public void TestCase2() {
        int width = 4;
        int height = 3;
        int expected = 10;
        var actual = NumberOfWaysToTraverseGraph.numberOfWaysToTraverseGraphSecond(width, height);
        assertTrue(expected == actual);
    }

}