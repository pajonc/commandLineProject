package com.chrzanop.coding.algoexpert.arrays;

public class MinRewards {

    // O(n2) time | O(n) space
    public int minRewards(int[] scores) {

        int[] rewards = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            rewards[i] = 1;
        }

        int j = 1;
        for (int i = 1; i < scores.length; i++) {
            j = i;
            // left backtrack decrease increment
            while (j > 0 && scores[j] < scores[j - 1] && rewards[j] >= rewards[j - 1]) {
                rewards[j - 1] = rewards[j] + 1;
                j--;
            }
            // left backtrack increase increment
            while (j > 0 && scores[j] > scores[j - 1] && rewards[j] <= rewards[j - 1]) {
                rewards[j] = rewards[j-1] + 1;
                j--;
            }

        }

        int sumRewards = 0;
        for (int i = 0; i < rewards.length; i++) {
            sumRewards += rewards[i];
        }

        return sumRewards;
    }

}
