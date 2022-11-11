package com.chrzanop.coding.algoexpert.arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SmallestDifferenceTest {


    @Test
    public void shouldPassTestCases() {
        SmallestDifference sd = new SmallestDifference();
        int[] expected = {28, 26};
        assertTrue(
                Arrays.equals(
                        sd.smallestDifferenceSolution1(
                                new int[] {-1, 5, 10, 20, 28, 3}, new int[] {26, 134, 135, 15, 17}),
                        expected));

        assertTrue(
                Arrays.equals(
                        sd.smallestDifferenceSolution2(
                                new int[] {-1, 5, 10, 20, 28, 3}, new int[] {26, 134, 135, 15, 17}),
                        expected));
    }

}