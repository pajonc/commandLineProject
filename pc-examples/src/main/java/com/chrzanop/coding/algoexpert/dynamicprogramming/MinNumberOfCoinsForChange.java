package com.chrzanop.coding.algoexpert.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinNumberOfCoinsForChange {

    // O(n*d) time | O(n) space - where n is target number and d is size of denoms
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] numOfCoins = new int[n + 1];
        Arrays.fill(numOfCoins, Integer.MAX_VALUE);
        numOfCoins[0] = 0;
        int toCompare = 0;
        for (int denom : denoms) {
            for (int amount = 0; amount < numOfCoins.length; amount++) {
                if (denom <= amount) {
                    int i = amount - denom;
                    if (numOfCoins[i] == Integer.MAX_VALUE) {
                        toCompare = numOfCoins[i];
                    } else {
                        toCompare = numOfCoins[i] + 1;
                    }
                    numOfCoins[amount] = Math.min(numOfCoins[amount], toCompare);
                }
            }
        }
        return numOfCoins[n] != Integer.MAX_VALUE ? numOfCoins[n] : -1;
    }


    // O(nlogn + n)  time | O(n) space
    public static int minNumberOfCoinsForChange_Mine(int n, int[] denoms) {
        int currentValue = 0;

        Arrays.sort(denoms);
        List<Integer> coins = new ArrayList<>();

        for (int i = denoms.length - 1; i >= 0; i--) {
            while (currentValue + denoms[i] <= n) {
                currentValue += denoms[i];
                coins.add(denoms[i]);
            }
        }

        if (currentValue == n) {
            return coins.size();
        }
        return -1;
    }


}
