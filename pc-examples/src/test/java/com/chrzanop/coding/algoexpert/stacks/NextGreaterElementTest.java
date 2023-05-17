package com.chrzanop.coding.algoexpert.stacks;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NextGreaterElementTest {

    @Test
    public void TestCase1() {
        int[] input = new int[] {2, 5, -3, -4, 6, 7, 2};
        int[] expected = new int[] {5, 6, 6, 6, 7, -1, 5};
        int[] actual = new NextGreaterElement().nextGreaterElement(input);
        assert (expected.equals(actual));
    }

}