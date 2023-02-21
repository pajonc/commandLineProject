package com.chrzanop.coding.algoexpert.graphs;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SingleCycleCheck {

    @Test
    public void TestCase1() {
        assertTrue(hasSingleCycle(new int[]{2, 3, 1, -4, -4, 2}));
        assertFalse(hasSingleCycle(new int[]{0, 1, 1, 1, 1}));
        assertFalse(hasSingleCycle(new int[]{1, -1, 1, -1}));
        assertFalse(hasSingleCycle(new int[]{1, 1, 0, 1, 1}));
        assertFalse(hasSingleCycle(new int[]{10, 11, -6, -23, -2, 3, 88, 909, -26}));
    }

    private static final int STARTING_IDX = 0;

    // O(n) time | O(1) space - where n is the size of input array
    public static boolean hasSingleCycle(int[] array) {
        int currentIdx = STARTING_IDX;
        int numElementsVisited = 0;

        while (numElementsVisited < array.length) {
            if (numElementsVisited > 0 && currentIdx == STARTING_IDX) {
                return false;
            }
            numElementsVisited++;
            currentIdx = getNextIdx(array, currentIdx);
        }

        return currentIdx == STARTING_IDX;
    }

    private static int getNextIdx(int[] array, int idx) {
        int jump = array[idx];
        int move = (jump + idx) % array.length;
        return move >= 0 ? move : (move + array.length);
    }

}
