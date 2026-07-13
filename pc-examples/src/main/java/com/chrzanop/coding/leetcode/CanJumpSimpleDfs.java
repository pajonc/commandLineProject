package com.chrzanop.coding.leetcode;

public class CanJumpSimpleDfs {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        CanJumpSimpleDfs canJump = new CanJumpSimpleDfs();
        System.out.println(canJump.canJump(nums));
    }


    public boolean canJump(int[] nums) {
        boolean reached = false;

        return dfsJump(nums, 0);
    }


    boolean dfsJump(int[] nums, int index) {

        System.out.println("Index " + index);

        if (index == nums.length - 1) {
            return true;
        }

        for (int i = 1; i <= nums[index]; i++) {
            System.out.println("Children index " + i);

            if (dfsJump(nums, index+i)) {
                return true;
            }

        }
        return false;
    }


}
