package com.chrzanop.coding.ai;

public class MinCostStairs {

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // dp[i] will store the min cost to reach step i
        int[] dp = new int[n + 1];

        // Base cases: starting at step 0 or 1 costs nothing yet
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            // Cost to reach i = min(cost of coming from i-1, cost of coming from i-2)
            int option1 = dp[i - 1] + cost[i - 1];
            int option2 = dp[i - 2] + cost[i - 2];
            dp[i] = Math.min(option1, option2);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        // Path: Start at index 1 (cost 15), then jump to the top. Total = 15.
        System.out.println("Minimum cost: " + minCostClimbingStairs(cost));
    }

}
