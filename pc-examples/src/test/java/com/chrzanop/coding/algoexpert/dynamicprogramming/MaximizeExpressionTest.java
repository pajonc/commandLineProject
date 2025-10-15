package com.chrzanop.coding.algoexpert.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximizeExpressionTest {

    @Test
    public void TestCase1() {
        int[] input = new int[] {3, 6, 1, -3, 2, 7};
        int expected = 4;
        var actual = new MaximizeExpression().maximizeExpression(input);
        assertTrue(expected == actual);
    }

    @Test
    public void TestCase2() {
        int[] input = new int[] {3, 6, 1, -3, 2, 7};
        int expected = 4;
        var actual = new MaximizeExpression().maximizeExpressionRecursivelyBackTrack(input);
        assertTrue(expected == actual);
    }

    @Test
    public void TestCase3() {
        int[] input = new int[] {3, 6, 1, -3, 2, 7};
        int expected = 4;
        var actual = new MaximizeExpression().maximizeExpressionRec(input);
        assertTrue(expected == actual);
    }

    @Test
    public void TestCase1Algo() {
        int[] input = new int[] {3, 6, 1, -3, 2, 7};
        int expected = 4;
        var actual = new MaximizeExpression().maximizeExpressionAlgo(input);
        assertTrue(expected == actual);
    }
}