package com.chrzanop.coding.algoexpert.string;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringContaining {

    // O(b+s) time | O(b+s) where b is the size of big string and s size of the small string
    public static String smallestSubstringContaining(String bigString, String smallString) {

        if (bigString == null || smallString == null || bigString.length() < smallString.length()) return "";

        // 1. Build frequency map for the target string smallString
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : smallString.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0, right = 0;
        int required = targetMap.size(); // Number of unique chars in smallString
        int formed = 0;                  // How many unique chars meet the required count in window

        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        while (right < bigString.length()) {
            // Expand the window
            char c = bigString.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // If the current character'bigString count matches the target count
            if (targetMap.containsKey(c) &&
                    windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
                formed++;
            }

            // Try to shrink the window if it'bigString valid
            while (left <= right && formed == required) {
                c = bigString.charAt(left);

                // Update the smallest window result
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                // Remove character from the left and move the pointer
                windowMap.put(c, windowMap.get(c) - 1);
                if (targetMap.containsKey(c) &&
                        windowMap.get(c).intValue() < targetMap.get(c).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : bigString.substring(minStart, minStart + minLen);
    }
}
