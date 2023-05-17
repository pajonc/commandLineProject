package com.chrzanop.coding.algoexpert.stacks;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NextGreaterElementTest {

    @Test
    public void TestCase1() {
        int[] input = new int[] {2, 5, -3, -4, 6, 7, 2};
        int[] expected = new int[] {5, 6, 6, 6, 7, -1, 5};
        int[] actual = new NextGreaterElement().nextGreaterElement_Algo1(input);
        int[] actual2= new NextGreaterElement().nextGreaterElement_Algo2(input);
        int[] actual3 = new NextGreaterElement().nextGreaterElementComplex(input);
        assertArrayEquals(expected, actual);
        assertArrayEquals(expected, actual2);
        assertArrayEquals(expected, actual3);
    }

}