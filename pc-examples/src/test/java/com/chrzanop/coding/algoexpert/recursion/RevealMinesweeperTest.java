package com.chrzanop.coding.algoexpert.recursion;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RevealMinesweeperTest {

    @Test
    public void TestCase1() {
        String[][] board =
                new String[][] {
                        {"H", "H", "H", "H", "M"},
                        {"H", "H", "M", "H", "H"},
                        {"H", "H", "H", "H", "H"},
                        {"H", "H", "H", "H", "H"}
                };
        int row = 3;
        int column = 4;
        String[][] expected =
                new String[][] {
                        {"0", "1", "H", "H", "M"},
                        {"0", "1", "M", "2", "1"},
                        {"0", "1", "1", "1", "0"},
                        {"0", "0", "0", "0", "0"}
                };
        String[][] actual = new RevealMinesweeper().revealMinesweeper(board, row, column);

        assertTrue(expected.length == actual.length);
        assertTrue(expected[0].length == actual[0].length);

        for (int currRow = 0; currRow < expected.length; currRow++) {
            for (int currColumn = 0; currColumn < expected[0].length; currColumn++) {
                assertTrue(expected[currRow][currColumn].equals(actual[currRow][currColumn]));
            }
        }
    }

}