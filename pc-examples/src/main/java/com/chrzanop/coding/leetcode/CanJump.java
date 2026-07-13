package com.chrzanop.coding.leetcode;

public class CanJump {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump(nums));


        System.out.println("!!!!!!---------!!!!!!!!");

        int[] nums2 = {3,2,1,0,4};

        System.out.println(canJump.canJump(nums2));
    }

    public boolean canJump(int[] nums) {
        int maxReachable = 0;

        for (int i = 0; i < nums.length; i++) {
            // If the current index is greater than the maximum reachable index,
            // it means we've hit a trap (an unreachable index/zero block).
            if (i > maxReachable) {
                return false;
            }

            // Update the furthest index we can reach from the current spot
            System.out.println("maxreachable: " + maxReachable);
            System.out.println("i: " + i + " + nums[i]: "+ nums[i]);
            maxReachable = Math.max(maxReachable, i + nums[i]);
            System.out.println("maxreachable after: "+ maxReachable);
            System.out.println("-----------");

            // Optimization: If we can already reach or exceed the last index, return true
            if (maxReachable >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}
