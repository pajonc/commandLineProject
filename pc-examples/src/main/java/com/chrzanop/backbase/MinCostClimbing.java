package com.chrzanop.backbase;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbing {

    // Both options allowed to start from 0 or 1 stair

    public static void main(String[] args) {
        System.out.println("Min costs climbing stairs");
        int[] costs = {10, 15, 20};
//        minCostClimbingBU(costs);
        minCostClimbingBottomUp2(costs);
        minCostClimbingBottomUp3(costs);
        minCostClimbingTD(costs);
    }

    public static int minCostClimbingBU(int[] costs) {

        return minCostClimbingBottomUp(costs);
    }

    private static int minCostClimbingBottomUp2(int[] costs) {
        int[] dp = new int[costs.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] += Math.min(costs[i - 1], costs[i - 2]);
        }
        System.out.println("BottomUp forward: " + dp[costs.length]);
        return dp[costs.length];
    }

    //reverse bottom up
    private static int minCostClimbingBottomUp3(int[] costs) {

        int[] dpCosts = new int[costs.length + 1];
        for (int i = 0; i < costs.length; i++) {
            dpCosts[i] = costs[i];
        }
        dpCosts[costs.length] = 0;

        for (int i = dpCosts.length - 3; i >= 0; i--) {
            dpCosts[i] += Math.min(dpCosts[i + 1], dpCosts[i + 2]);
        }
        System.out.println("BottomUp reverse: " + Math.min(dpCosts[0], dpCosts[1]));
        return Math.min(dpCosts[0], dpCosts[1]);

    }


    private static int minCostClimbingBottomUp(int[] costs) {

        //option from zero
        int minCostZero = 0;
        int i = 0;
        while (i < costs.length) {
            int costFirst = i + 1 < costs.length ? costs[i + 1] : 0;
            int costSecond = i + 2 < costs.length ? costs[i + 2] : 0;
            minCostZero += Math.min(costs[i] + costFirst, costs[i] + costSecond);
            i = costFirst < costSecond ? i + 1 : i + 2;
        }

        //option from one
        int minCostOne = 0;
        i = 1;
        while (i < costs.length) {
            int costFirst = i + 1 < costs.length ? costs[i + 1] : 0;
            int costSecond = i + 2 < costs.length ? costs[i + 2] : 0;
            minCostOne += Math.min(costs[i] + costFirst, costs[i] + costSecond);
            i = costFirst < costSecond ? i + 1 : i + 2;
        }
        return Math.min(minCostZero, minCostOne);
    }

    public static int minCostClimbingTD(int[] costs) {
        Map<Integer, Integer> memoize = new HashMap<>();
        memoize.put(costs.length, 0);
        memoize.put(costs.length + 1, 0);
        minCostClimbingTopDown(costs, memoize, 0);
        System.out.println("TopDown: " + Math.min(memoize.get(0), memoize.get(1)));
        return Math.min(memoize.get(0), memoize.get(1));
    }

    private static int minCostClimbingTopDown(int[] costs, Map<Integer, Integer> memoize, int stair) {
        if (memoize.containsKey(stair)) {
            return memoize.get(stair);
        }
        int cost = 0;
        for (int step = 1; step <= 2; step++) {
            int left = minCostClimbingTopDown(costs, memoize, stair + step);
            int right = minCostClimbingTopDown(costs, memoize, stair + step);
            cost = costs[stair] + Math.min(left, right);
        }
        memoize.put(stair, cost);

        return memoize.get(stair);
    }


    //wrong below

//    private static int minCostClimbingTopDown(int[] costs, Map<Integer, Integer> memoize, int stair) {
//        if (memoize.containsKey(stair)) {
//            return memoize.get(stair);
//        }
//
//        int cost = 0;
//        int localStair = stair;
//        for (int step = 1; step <= 2; step++) {
//            if (localStair - step < 0) continue;
//            localStair = localStair - step;
//            cost += costs[localStair] + minCostClimbingTopDown(costs, memoize, localStair);
//        }
//        if(memoize.containsKey(stair)) {
//            memoize.put(stair, Math.min(memoize.get(stair), cost));
//        } else {
//            memoize.put(stair, cost);
//        }
////        memoize.putIfAbsent(stair, cost + stair >= 0 ? costs[stair] : 0);
////        memoize.put(stair, Math.min(memoize.get(stair), cost + stair >= 0 ? costs[stair] : 0));
//
//        return memoize.get(stair);
//    }
//
//    private static int minCostClimbingTopDown(int[] costs, Map<Integer, Integer> memoize, int stair, int currentCost) {
//        if (stair == costs.length) {
//            return 0;
//        }
//        if (memoize.containsKey(stair)) {
//            return memoize.get(stair);
//        }
//        for (int step = 1; step <= 2; step++) {
//            if (stair + 1 > costs.length) continue;
//            stair = stair + 1;
//            currentCost += minCostClimbingTopDown(costs, memoize, stair, currentCost);
//        }
//        memoize.putIfAbsent(stair,  currentCost);
//        memoize.put(stair, Math.min(memoize.get(stair), currentCost));
//        return currentCost;
//    }

}
