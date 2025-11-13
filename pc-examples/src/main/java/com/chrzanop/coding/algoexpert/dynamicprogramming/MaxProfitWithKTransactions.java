package com.chrzanop.coding.algoexpert.dynamicprogramming;

public class MaxProfitWithKTransactions {

    // O(nk) time | O(nk) space
    public static int maxProfitWithKTransactions(int[] prices, int k) {
        if (prices.length < 2) return 0;

        int[][] profits = new int[k + 1][prices.length];

        for (int transaction = 1; transaction <= k; transaction++) {
            for (int day = 1; day < prices.length; day++) {

                int prevProfit = profits[transaction][day - 1];
                int currentPrice = prices[day];

                int localMax = Integer.MIN_VALUE;
                for (int x = 0; x < day; x++) {
                    int profit = profits[transaction - 1][x];
                    int price = prices[x];
                    int calc = profit - price;
                    localMax = Math.max(localMax, calc);
                }
                profits[transaction][day] = Math.max(prevProfit, currentPrice + localMax);

            }

        }

        return profits[k][prices.length - 1];
    }

}
