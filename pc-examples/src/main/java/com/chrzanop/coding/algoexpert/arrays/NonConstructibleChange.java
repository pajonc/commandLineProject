package com.chrzanop.coding.algoexpert.arrays;

import java.util.Arrays;

public class NonConstructibleChange {

    public static void main(String[] args) {
        int[] coins = new int[]{5, 7, 1, 1, 2, 3, 22};
        int expected = 20;

        System.out.println(nonConstructibleChange(coins) == expected);
    }

    // O(nlogn) time |  O(1) space  - where n is the number of coins
    /*
    The minimum amount of change that you cannot create
    example [1,2,5] -> 4 because we're able to create 1, 2, 3, _ ,5, 7, 8
     */
    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);

        int change = 0;
        for (int i = 0; i < coins.length; i++) {
            if (change + 1 < coins[i]) {
                return change + 1;
            }
            change = change + coins[i];
        }

        return change + 1;
    }
}

