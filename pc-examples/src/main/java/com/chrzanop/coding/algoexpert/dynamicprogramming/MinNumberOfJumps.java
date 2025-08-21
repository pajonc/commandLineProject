package com.chrzanop.coding.algoexpert.dynamicprogramming;

public class MinNumberOfJumps {


    // O(n^2) time | O(n) space
    public static int minNumberOfJumps(int[] array) {
        int[] jumps = new int[array.length];
        jumps[0] = 0;
        for (int i = 1; i < jumps.length; i++) {
            jumps[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                int jump = array[j] + j;
                if (jump >= i) {
                    jumps[i] = Math.min(jumps[j] + 1, jumps[i]);
                }
            }
        }

        return jumps[jumps.length - 1];
    }

    // O(n) time | O(n) space
    public static int minNumberOfJumps2(int[] array) {
        if(array.length == 1) {
            return 0;
        }
        int maxReach = array[0];
        int steps = array[0];
        int jumps =  0;

        for (int i = 1; i < array.length; i++) {
            maxReach = Math.max(maxReach, array[i] + i);
            steps--;
            if(steps == 0) {
                steps = maxReach - i;
                jumps++;
            }
        }
        return jumps+ 1;
    }

}
