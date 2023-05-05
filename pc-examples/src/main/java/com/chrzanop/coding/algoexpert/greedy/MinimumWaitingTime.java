package com.chrzanop.coding.algoexpert.greedy;

import java.util.Arrays;

public class MinimumWaitingTime {

    // O(nlogn + n) --> O(nlogn) time | O(1) space
    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);

        int totalWaitingTime = 0;
        for (int i = 0; i < queries.length; i++) {
            int duration = queries[i];
            int queriesLeft = queries.length - (i + 1);
            totalWaitingTime += duration * queriesLeft;
        }
        return totalWaitingTime;
    }
}
