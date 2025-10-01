package com.chrzanop.coding.algoexpert.dynamicprogramming;

import java.util.*;

public class NumbersInPi {

    // O(n^3 + m) time | O(n+m) space - where n is the number of digits in Pi and
    // m is the number of favorite numbers
    public static int numbersInPi(String pi, String[] numbers) {
        Set<String> numbs = new HashSet<>(Arrays.asList(numbers));
        Map<Integer, Integer> memoize = new HashMap<>();

        int minSpace = findMinSpaces(pi, numbs, 0, memoize);
        return minSpace == Integer.MAX_VALUE ? -1 : minSpace;
    }

    private static int findMinSpaces(String pi, Set<String> numbs, int index, Map<Integer, Integer> memoize) {
        if (index == pi.length()) {
            return -1;
        }
        if (memoize.containsKey(index)) {
            return memoize.get(index);
        }
        int minSpaces = Integer.MAX_VALUE;
        for (int i = index; i < pi.length(); i++) {
            String prefix = pi.substring(index, i + 1);
            if (numbs.contains(prefix)) {
                int minSpacesInSuffix = findMinSpaces(pi, numbs, i + 1, memoize);
                if (minSpacesInSuffix == Integer.MAX_VALUE) {
                    minSpaces = Math.min(minSpaces, minSpacesInSuffix);
                } else {
                    minSpaces = Math.min(minSpaces, minSpacesInSuffix + 1);
                }
            }
        }
        memoize.put(index, minSpaces);
        return minSpaces;
    }


    public static int numbersInPiOptimal(String pi, String[] numbers) {
        int[] result = new int[pi.length() + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;

        for (int i = 0; i < result.length; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                continue;
            }

            String subStr = pi.substring(i);

            for (String str : numbers) {
                if (!subStr.startsWith(str)) {
                    continue;
                }

                int index = i + str.length();
                result[index] = Math.min(result[index], result[i] + 1);

            }

        }

        return result[pi.length()] == Integer.MAX_VALUE ? -1 : result[pi.length()] - 1;
    }
}
