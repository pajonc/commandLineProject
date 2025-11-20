package com.chrzanop.coding.algoexpert.dynamicprogramming;

import java.util.Arrays;

public class PalindromePartitioningMinCuts {

    //O(n^3) time | O(n^2) space
    public static int palindromePartitioningMinCuts(String str) {
        boolean[][] matrixIsPalindrome = new boolean[str.length()][str.length()];

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                matrixIsPalindrome[i][j] = isPalindrome(str.substring(i, j + 1));
            }
        }

        int[] cuts = new int[str.length()];
        Arrays.fill(cuts, Integer.MAX_VALUE);

        for (int i = 0; i < str.length(); i++) {
            if (matrixIsPalindrome[0][i]) {
                cuts[i] = 0;
            } else {
                cuts[i] = Math.min(cuts[i], cuts[i - 1] + 1);
                for (int j = 1; j < i; j++) {
                    if (matrixIsPalindrome[j][i]) {
                        cuts[i] = Math.min(cuts[i], cuts[j - 1] + 1);
                    }
                }
            }
        }

        return cuts[cuts.length - 1];
    }


    static boolean isPalindrome(String str) {
        int leftIdx = 0;
        int rightIdx = str.length() - 1;
        while (leftIdx < rightIdx) {
            int leftChar = str.charAt(leftIdx);
            int rightChar = str.charAt(rightIdx);
            if (leftChar != rightChar) {
                return false;
            }
            leftIdx++;
            rightIdx--;
        }
        return true;
    }
}
