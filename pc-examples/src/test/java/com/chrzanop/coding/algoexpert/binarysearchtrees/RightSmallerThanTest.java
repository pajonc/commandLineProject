package com.chrzanop.coding.algoexpert.binarysearchtrees;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RightSmallerThanTest {

    @Test
    void rightSmallerThan() {
        List<Integer> array = Arrays.asList(8, 5, 11, -1, 3, 4, 2);
        List<Integer>  expected = Arrays.asList(5, 4, 4, 0, 1, 1, 0);
        List<Integer>  actual = RightSmallerThan.rightSmallerThanNaiveSolution(array);
        List<Integer>  actual2 = RightSmallerThan.rightSmallerThanWithBst(array);
        assertArrayEquals(expected.toArray(), actual.toArray());
        assertArrayEquals(expected.toArray(), actual2.toArray());
    }
}