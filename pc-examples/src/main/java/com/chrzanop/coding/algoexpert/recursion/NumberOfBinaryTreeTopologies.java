package com.chrzanop.coding.algoexpert.recursion;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NumberOfBinaryTreeTopologies {


    @Test
    public void TestCase1() {
        assertTrue(numberOfBinaryTreeTopologies(3) == 5);
    }


    public static int numberOfBinaryTreeTopologies(int n) {

        if (n == 0) {
            return 1;
        }
        int numberOfTrees = 0;
        for (int lSize = 0; lSize < n; lSize++) {
            int rSize = n - 1 - lSize;
            int numberOfLeftTreeSize = numberOfBinaryTreeTopologies(lSize);
            int numberofRightTreeSize = numberOfBinaryTreeTopologies(rSize);
            numberOfTrees += numberOfLeftTreeSize * numberofRightTreeSize;
        }
        return numberOfTrees;
    }


}
