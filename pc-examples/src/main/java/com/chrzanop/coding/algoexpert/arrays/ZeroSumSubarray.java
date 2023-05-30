package com.chrzanop.coding.algoexpert.arrays;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubarray {

    // O(n) time | O(n) space
    public boolean zeroSumSubarray(int[] nums) {
        Set<Integer> sums = new HashSet<>();
        sums.add(0);
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (sums.contains(currentSum)) {
                return true;
            }
            sums.add(currentSum);
        }
        return false;
    }
}
