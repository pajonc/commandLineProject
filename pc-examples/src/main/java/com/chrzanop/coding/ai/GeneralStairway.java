package com.chrzanop.coding.ai;

public class GeneralStairway {

    public static int countWays(int n, int[] jumps) {
        int[] dp = new int[n + 1];

        // Base case: There is 1 way to be at the start (step 0)
        dp[0] = 1;

        // Iterate through every step from 1 to n
        for (int i = 1; i <= n; i++) {
            // Check each allowed jump
            for (int jump : jumps) {
                if (i - jump >= 0) {
                    dp[i] += dp[i - jump];
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 6;
        int[] allowedJumps = {1, 3, 5};

        System.out.println("Ways to climb " + n + " steps using " +
                java.util.Arrays.toString(allowedJumps) + ": " +
                countWays(n, allowedJumps));
    }
}
