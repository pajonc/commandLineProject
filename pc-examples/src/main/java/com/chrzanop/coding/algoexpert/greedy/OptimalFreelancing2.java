package com.chrzanop.coding.algoexpert.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class OptimalFreelancing2 {
    // O(n * log(n)) time | O(1) space - where n is the number of jobs
    public int optimalFreelancing(Map<String, Integer>[] jobs) {

        final int LENGTH_OF_WEEK = 7;
        boolean[] paymentsPerDay = new boolean[LENGTH_OF_WEEK];
        int sum_profit = 0;
        Arrays.sort(jobs, new Comparator<Map<String, Integer>>() {
            @Override
            public int compare(Map<String, Integer> o1, Map<String, Integer> o2) {
                return o2.get("payment").compareTo(o1.get("payment"));
            }
        });

        for (Map<String, Integer> job : jobs) {
            int deadline = Math.min(job.get("deadline"), LENGTH_OF_WEEK);
            int value = putInBestPosition(paymentsPerDay, deadline, job.get("payment"));
            sum_profit += value;
        }

        return sum_profit;
    }

    private int putInBestPosition(boolean[] paymentsPerDay, int deadline, int payment) {

        for (int i = deadline-1; i >=0 ; i--) {
            if(paymentsPerDay[i]==false) {
                paymentsPerDay[i] = true;
                return payment;
            }
        }
        return 0;

    }


}
