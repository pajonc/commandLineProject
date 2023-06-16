package com.chrzanop.coding.algoexpert.dynamicprogramming;

public class NumberOfWaysToMakeChange {

    // O(n*d) time | O(n) space where n is the target amount and d list of denominations
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] ways = new int[n + 1];
        ways[0] = 1;
        for (int denom : denoms) {
            for (int amount = 1; amount < n + 1; amount++) {
                if (denom <= amount) {
                    ways[amount] += ways[amount - denom];
                }
            }
        }
        return ways[n];
    }
}
