package com.chrzanop.coding.algoexpert.arrays;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MajorityElementTest {

    @Test
    public void TestCase1() {
        int[] input = new int[] {1, 2, 3, 2, 2, 1, 2};
        int expected = 2;
        int actual = new MajorityElement().majorityElement(input);
        assertTrue(expected == actual);
    }

    @Test
    public void TestCase2() {
        int[] input = new int[] {1, 1, 2, 2, 7};
        int expected = 7;
        int actual = new MajorityElement().majorityElement(input);
        assertTrue(expected == actual);
    }


}