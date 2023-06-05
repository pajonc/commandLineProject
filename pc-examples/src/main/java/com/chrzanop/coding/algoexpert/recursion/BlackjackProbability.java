package com.chrzanop.coding.algoexpert.recursion;

import java.util.HashMap;
import java.util.Map;

public class BlackjackProbability {


    // O(t-s) time | O(t-s) space - where t is the target, and s is the
    // starting hand
    public float blackjackProbability(int target, int startingHand) {
        Map<Integer, Float> memoize = new HashMap<>();
        return Math.round(calculateProbability(target, startingHand, memoize) * 1000f) / 1000f;
    }


    private float calculateProbability(int target, int startingHand, Map<Integer, Float> memoize) {

        if (memoize.containsKey(startingHand)) {
            return memoize.get(startingHand);
        }
        if (startingHand > target) {
            return 1;
        }
        if (startingHand + 4 >= target) {
            return 0;
        }

        float totalProbability = 0;
        for (int drawnCard = 1; drawnCard <= 10; drawnCard++) {
            totalProbability += .1 * calculateProbability(target, startingHand + drawnCard, memoize);
        }
        memoize.put(startingHand, totalProbability);
        return totalProbability;
    }
}



