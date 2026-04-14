package com.chrzanop.backbase;

import java.util.HashMap;
import java.util.Map;

public class StaircaseTraverse {

    public static void main(String[] args) {
        int height = 6;
        int maxSteps = 2;
        System.out.println("Bottom up staircase traversal: "+staircaseTraversalBotttomUp(height, maxSteps));
        System.out.println("Top down staircase traversal: "+staircaseTraversalTopDown(height, maxSteps));
    }


    public static int staircaseTraversalBotttomUp(int height, int maxSteps) {

        int[] dp = new int[height + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int stair = 2; stair <= height; stair++) {
            for (int step = 1; step <= maxSteps; step++) {
                if (stair - step >= 0) {
                    dp[stair] += dp[stair - step];
                }
            }
        }
        return dp[height];
    }

    public static int staircaseTraversalTopDown(int height, int maxSteps) {

        Map<Integer, Integer> memoize = new HashMap<>();
        memoize.put(0, 1);
        memoize.put(1, 1);

        return staircaseTraversalTopDownMemoize(height, maxSteps, memoize);
    }

    private static int staircaseTraversalTopDownMemoize(int height, int maxSteps, Map<Integer, Integer> memoize) {

        if (memoize.containsKey(height)) {
            return memoize.get(height);
        }

        int result = 0;
        for (int step = 1; step <= maxSteps; step++) {
            result += staircaseTraversalTopDownMemoize(height - step, maxSteps, memoize);
        }
        memoize.put(height, result);

        return result;
    }


}
