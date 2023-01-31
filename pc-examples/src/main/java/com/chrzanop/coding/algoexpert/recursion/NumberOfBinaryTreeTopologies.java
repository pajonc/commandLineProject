package com.chrzanop.coding.algoexpert.recursion;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class NumberOfBinaryTreeTopologies {


    @Test
    public void TestCase1() {
        assertTrue(numberOfBinaryTreeTopologiesNaive(3) == 5);
    }


    public static int numberOfBinaryTreeTopologies(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);
        return numberOfBinaryTreeTopologies(n, cache);
    }


    private static int numberOfBinaryTreeTopologies(int n, Map<Integer, Integer> cache) {

        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int numberOfTrees = 0;
        for (int lSize = 0; lSize < n; lSize++) {
            int rSize = n - 1 - lSize;
            int numberOfLeftTreeSize = numberOfBinaryTreeTopologies(lSize);
            int numberofRightTreeSize = numberOfBinaryTreeTopologies(rSize);
            numberOfTrees += numberOfLeftTreeSize * numberofRightTreeSize;
        }
        cache.put(n, numberOfTrees);
        return numberOfTrees;
    }


    public static int numberOfBinaryTreeTopologiesNaive(int n) {
        if (n == 0) {
            return 1;
        }
        int numberOfTrees = 0;
        for (int lSize = 0; lSize < n; lSize++) {
            int rSize = n - 1 - lSize;
            int numberOfLeftTreeSize = numberOfBinaryTreeTopologiesNaive(lSize);
            int numberofRightTreeSize = numberOfBinaryTreeTopologiesNaive(rSize);
            numberOfTrees += numberOfLeftTreeSize * numberofRightTreeSize;
        }
        return numberOfTrees;
    }



}
