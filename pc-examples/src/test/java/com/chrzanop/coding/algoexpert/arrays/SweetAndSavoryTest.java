package com.chrzanop.coding.algoexpert.arrays;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SweetAndSavoryTest {

    @Test
    public void TestCase1() {
        int[] dishes = new int[] {-3, -5, 1, 7};
        int target = 8;
        int[] expected = new int[] {-3, 7};
        int[] actual = new SweetAndSavory().sweetAndSavory(dishes, target);
        assertTrue(actual.length == 2);
        assertTrue(actual[0] == expected[0]);
        assertTrue(actual[1] == expected[1]);
    }

}