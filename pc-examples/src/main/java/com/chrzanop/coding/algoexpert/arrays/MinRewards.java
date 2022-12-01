package com.chrzanop.coding.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MinRewards {


    // O(n) time - only 2 simple loops | O(n) space
    public static int minRewardsCreative(int[] scores) {
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);
        // fill Right
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > scores[i - 1]) {
                rewards[i] = rewards[i - 1] + 1;
            }
        }
        // fill left
        for (int i = scores.length - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1]) {
                rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
            }
        }
        return IntStream.of(rewards).sum();
    }


    // O(n) time | O(n) space
    public static int minRewards(int[] scores) {
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);

        for (Integer minIdx : getLocalMinIdxs(scores)) {
            expandFromLocalMinIdx(minIdx, scores, rewards);
        }

        return IntStream.of(rewards).sum();
    }

    private static List<Integer> getLocalMinIdxs(int[] array) {
        List<Integer> localMinIdxs = new ArrayList<>();
        if (array.length == 1) {
            return Arrays.asList(0);
        }
        for (int i = 0; i < array.length; i++) {
            if (i == 0 && array[i] < array[i + 1]) {
                localMinIdxs.add(i);
            }
            if (i == array.length - 1 && array[i - 1] > array[i]) {
                localMinIdxs.add(i);
            }
            if (i == 0 || i == array.length - 1) {
                continue;
            }
            if (array[i] < array[i + 1] && array[i] < array[i - 1]) {
                localMinIdxs.add(i);
            }
        }

        return localMinIdxs;
    }

    private static void expandFromLocalMinIdx(int minIdx, int[] scores, int[] rewards) {
        int leftIdx = minIdx - 1;
        int rightIdx = minIdx + 1;
        // left expanding
        while (leftIdx >= 0 && scores[leftIdx] > scores[leftIdx + 1]) {
            rewards[leftIdx] = Math.max(rewards[leftIdx], rewards[leftIdx + 1] + 1);
            leftIdx--;
        }
        // right expanding
        while (rightIdx < scores.length && scores[rightIdx] > scores[rightIdx - 1]) {
            rewards[rightIdx] = rewards[rightIdx - 1] + 1;
            rightIdx++;
        }
    }


    // O(n2) time | O(n) space
    public int minRewardsNaiveSolution(int[] scores) {

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
                rewards[j] = rewards[j - 1] + 1;
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
