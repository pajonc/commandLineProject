package com.chrzanop.coding.algoexpert.greedy;

import java.util.Map;

public class OptimalFreelancing {

    public int optimalFreelancing(Map<String, Integer>[] jobs) {

        int[] paymentsPerDay = new int[7];

        for (Map<String, Integer> job : jobs) {
            int deadline = Math.min(job.get("deadline") - 1, 6);
            putInBestPosition(paymentsPerDay, deadline, job.get("payment"));
        }

        int sum_profit=0;
        for (int i = 0; i < paymentsPerDay.length; i++) {
            sum_profit += paymentsPerDay[i];
        }

        return sum_profit;
    }

    private void putInBestPosition(int[] paymentsPerDay, int deadline, int payment) {

        while (deadline >= 0 && payment != 0) {
            if(payment > paymentsPerDay[deadline]) {
                int temp = paymentsPerDay[deadline];
                paymentsPerDay[deadline] = payment;
                payment = temp;
            }
            deadline--;
        }

    }
}
