package com.chrzanop.coding.algoexpert.arrays;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MajorityElementTest {

    @Test
    public void TestCase1() {
        int[] input = new int[]{1, 2, 3, 2, 2, 1, 2};
        int expected = 2;
        int actual = new MajorityElement().majorityElement(input);
        assertTrue(expected == actual);
    }

    @Test
    public void TestCase2() {
        int[] input = new int[]{1, 2, 3, 2, 3, 2, 2, 4, 2};
        int expected = 2;
        int actual = new MajorityElement().majorityElement(input);
        assertTrue(expected == actual);
    }

    @Test
    public void TestCase3() {
        int[] input = new int[]{1, 1, 2, 2, 7, 2, 2};
        int expected = 2;
        int actual = new MajorityElement().majorityElement_Algo2(input);
        assertTrue(expected == actual);
    }

    @Test
    public void TestCase4() {
        int[] input = new int[]{1, 1, 6, 6, 7, 6, 6};
        int expected = 6;
        int actual = new MajorityElement().majorityElement_Algo2(input);
        assertTrue(expected == actual);
    }


}