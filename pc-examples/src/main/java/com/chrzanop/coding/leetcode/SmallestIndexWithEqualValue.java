package com.chrzanop.coding.leetcode;

public class SmallestIndexWithEqualValue {

    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(i%10 == nums[i]) return i;
        }
        return -1;
    }
}
