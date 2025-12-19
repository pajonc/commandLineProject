package com.chrzanop.coding.algoexpert.dynamicprogramming;

import java.util.*;

public class LongestStringChain {

    static class StringChain {
        String nextString;
        Integer maxChainLength;

        public StringChain(String nextString, Integer maxChainLength) {
            this.nextString = nextString;
            this.maxChainLength = maxChainLength;
        }
    }

    // O(n*m^2 + nlog(n)) time | O(nm) space - where n is the number of strings and m is the length of the longest string
    public static List<String> longestStringChain(List<String> strings) {

        Map<String, StringChain> stringChains = new HashMap<>();
        for (String str : strings) {
            stringChains.put(str, new StringChain("", 1));
        }
        Collections.sort(strings, Comparator.comparingInt(String::length));
//        List<String> sortedStrings = new ArrayList<>(strings);
//        sortedStrings.sort((a, b) -> a.length() - b.length());

        for (String str : strings) {
            findLongestStringChain(str, stringChains);
        }

        return buildLongestStringChain(strings, stringChains);
    }

    private static void findLongestStringChain(String string, Map<String, StringChain> stringChains) {
        for (int i = 0; i < string.length(); i++) {
            String smallerString = getSmallerString(string, i);
            if (!stringChains.containsKey(smallerString)) continue;
            tryUpdateLongestStringChain(string, smallerString, stringChains);
        }
    }

    private static void tryUpdateLongestStringChain(String currentString, String smallerString, Map<String, StringChain> stringChains) {
        Integer currentStringChainLength = stringChains.get(currentString).maxChainLength;
        Integer smallerStringChainLength = stringChains.get(smallerString).maxChainLength;
        if (currentStringChainLength < smallerStringChainLength + 1) {
            stringChains.get(currentString).maxChainLength = smallerStringChainLength + 1;
            stringChains.get(currentString).nextString = smallerString;
        }
    }

    private static String getSmallerString(String str, int index) {
        return str.substring(0, index) + str.substring(index + 1);
    }

    private static List<String> buildLongestStringChain(List<String> strings, Map<String, StringChain> stringChains) {
        // find the string that starts the longest string chain
        int maxChainLength = 0;
        String chainStartingString = "";
        for (String string : strings) {
            if(stringChains.get(string).maxChainLength > maxChainLength) {
                maxChainLength = stringChains.get(string).maxChainLength;
                chainStartingString = string;
            }
        }

        // starting at the string found above , build the longest string chain.
        List<String> ourLongestStringChain = new ArrayList<>();
        String currentString = chainStartingString;
        while(currentString != "") {
            ourLongestStringChain.add(currentString);
            currentString = stringChains.get(currentString).nextString;
        }
        return ourLongestStringChain.size() == 1 ? new ArrayList<>() : ourLongestStringChain;

    }
}
