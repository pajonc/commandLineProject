package com.chrzanop.coding.algoexpert.recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class StaircaseTraversal {

    @Test
    public void shouldPassCheck() {
        StaircaseTraversal traversal = new StaircaseTraversal();
        int stairs = 4;
        int maxSteps = 2;
        int expected = 5;
        int actual = traversal.staircaseTraversalSlicingWindow(stairs, maxSteps);
        assertTrue(expected == actual);
    }


    // O(k^n) time | O(n) space - where n is the height of staircase and k is the number of allowed steps
    public int staircaseTraversal(int height, int maxSteps) {
        return numberOfWaysToTop(height, maxSteps);
    }

    private int numberOfWaysToTop(int height, int maxSteps) {
        if (height == 0 || height == 1) {
            return 1;
        }
        int numberOfWays = 0;
        for (int step = 1; step < Math.min(maxSteps, height) + 1; step++) {
            numberOfWays += numberOfWaysToTop(height - step, maxSteps);

        }
        return numberOfWays;
    }


    // O(k^n) time | O(n) space - where n is the height of staircase and k is the number of allowed steps
    public int staircaseTraversalMemoize(int height, int maxSteps) {
        Map<Integer, Integer> memoize = new HashMap<>();
        memoize.put(0, 1);
        memoize.put(1, 1);

        return numberOfWaysToTopMemoize(height, maxSteps, memoize);
    }

    private int numberOfWaysToTopMemoize(int height, int maxSteps, Map<Integer, Integer> memoize) {
        if (memoize.containsKey(height)) {
            return memoize.get(height);
        }
        int numberOfWays = 0;
        for (int step = 1; step < Math.min(maxSteps, height) + 1; step++) {
            numberOfWays += numberOfWaysToTopMemoize(height - step, maxSteps, memoize);
        }
        memoize.put(height, numberOfWays);
        return numberOfWays;
    }

    // O(n*k) time | O(n) space - where n is the height of staircase and k is the number of allowed steps
    public int staircaseTraversalDynamic(int height, int maxSteps) {
        int[] waysToTop = new int[height + 1];
        waysToTop[0] = 1;
        waysToTop[1] = 1;


        for (int currentHeight = 2; currentHeight < height + 1; currentHeight++) {
            int step = 1;
            while (step <= maxSteps && step <= currentHeight) {
                waysToTop[currentHeight] = waysToTop[currentHeight] + waysToTop[currentHeight - step];
                step += 1;
            }
        }

        return waysToTop[height];
    }


    // O(n) time | O(n) space - where n is the height of staircase and k is the number of allowed steps
    public int staircaseTraversalSlicingWindow(int height, int maxSteps) {

        int currentNumberOfWays = 0;
        ArrayList<Integer> waysToTop = new ArrayList<>();
        waysToTop.add(1);

        for (int currentHeight = 1; currentHeight < height + 1; currentHeight++) {

            int startOfWindow = currentHeight - maxSteps - 1;
            int endOfWindow = currentHeight - 1;

            if (startOfWindow >= 0) {
                currentNumberOfWays = currentNumberOfWays - waysToTop.get(startOfWindow);
            }

            currentNumberOfWays += waysToTop.get(endOfWindow);
            waysToTop.add(currentNumberOfWays);
        }
        return waysToTop.get(height);
    }


}
