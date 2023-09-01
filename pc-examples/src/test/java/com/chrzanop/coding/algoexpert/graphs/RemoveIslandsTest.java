package com.chrzanop.coding.algoexpert.graphs;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveIslandsTest {

    @Test
    public void TestCase1() {
        int[][] input =
                new int[][] {
                        {1, 0, 0, 0, 0, 0},
                        {0, 1, 0, 1, 1, 1},
                        {0, 0, 1, 0, 1, 0},
                        {1, 1, 0, 0, 1, 0},
                        {1, 0, 1, 1, 0, 0},
                        {1, 0, 0, 0, 0, 1},
                };
        int[][] expected =
                new int[][] {
                        {1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1},
                        {0, 0, 0, 0, 1, 0},
                        {1, 1, 0, 0, 1, 0},
                        {1, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 1},
                };
        int[][] actual = new RemoveIslands().removeIslands(input);
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                assertTrue(actual[i][j] == expected[i][j]);
            }
        }
    }


}