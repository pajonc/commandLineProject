package com.chrzanop.coding.algoexpert.arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SpiralTraverseTest {

    SpiralTraverse st = new SpiralTraverse();

    @Test
    public void shouldPassIterative() {
        int[][] input =
                new int[][]{
                        {1, 2, 3, 4},
                        {12, 13, 14, 5},
                        {11, 16, 15, 6},
                        {10, 9, 8, 7},
                };

        int[][] input2 = {{1}};
        int[][] input3 =
                {
                        {1, 2},
                        {4, 3}
                };

        int[][] input4 =
                {
                        {1, 2},
                        {6, 3},
                        {5, 4}
                };

        int[][] input5 = {{1,2,3,4,5}};
        int[][] input6 = {{1},{2},{3}};

        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        List<Integer> expected2 = Arrays.asList(1);
        List<Integer> expected3 = Arrays.asList(1, 2, 3, 4);
        List<Integer> expected4 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> expected5 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected6 = Arrays.asList(1, 2, 3);
        List<Integer> actual = st.spiralTraverse(input);
        List<Integer> actual2 = st.spiralTraverse(input2);
        List<Integer> actual3 = st.spiralTraverse(input3);
        List<Integer> actual4 = st.spiralTraverse(input4);
        List<Integer> actual5 = st.spiralTraverse(input5);
        List<Integer> actual6 = st.spiralTraverse(input6);
        assertTrue(expected.equals(actual));
        assertTrue(expected2.equals(actual2));
        assertTrue(expected3.equals(actual3));
        assertTrue(expected4.equals(actual4));
        assertTrue(expected5.equals(actual5));
        assertTrue(expected6.equals(actual6));
    }

    @Test
    public void shouldPassRecurisve() {
        int[][] input =
                new int[][]{
                        {1, 2, 3, 4},
                        {12, 13, 14, 5},
                        {11, 16, 15, 6},
                        {10, 9, 8, 7},
                };
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);

        List<Integer> actual = st.spiralTraverseRecursive(input);

        assertTrue(expected.equals(actual));
    }
}