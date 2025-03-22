package com.chrzanop.coding.algoexpert.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiStringSearch {

    // O(bns) time | O(n) space
    public static List<Boolean> multiStringSearchComplexAlgo(String bigString, String[] smallStrings) {
        List<Boolean> solution = new ArrayList<>();
        for (String smallString : smallStrings) {
            solution.add(isInBigString(bigString, smallString));
        }
        return solution;
    }

    private static boolean isInBigString(String bigString, String smallString) {
        for (int i = 0; i < bigString.length(); i++) {
            if (i + smallString.length() > bigString.length()) {
                break;
            }
            if (isInBigString(bigString, smallString, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isInBigString(String bigString, String smallString, int startIdx) {
        int leftBigIdx = startIdx;
        int rightBigIdx = startIdx + smallString.length() - 1;
        int leftSmallIdx = 0;
        int rightSmallIdx = smallString.length() - 1;
        while (leftBigIdx <= rightBigIdx) {
            if (bigString.charAt(leftBigIdx) != smallString.charAt(leftSmallIdx)
                    || bigString.charAt(rightBigIdx) != smallString.charAt(rightSmallIdx)) {
                return false;
            }
            leftBigIdx++;
            rightBigIdx--;
            leftSmallIdx++;
            rightSmallIdx--;
        }
        return true;
    }

    public static List<Boolean> multiStringSearchComplex(String bigString, String[] smallStrings) {
        List<Boolean> result = new ArrayList<>();

        for (String smallString : smallStrings) {
            int j = 0;
            for (int k = 0; k < bigString.length(); k++) {
                for (int i = k; i < bigString.length(); i++) {
                    if (j < smallString.length()) {
                        if (bigString.charAt(i) == smallString.charAt(j)) {
                            j++;
                        } else {
                            break;
                        }
                    }
                }
                if (j == smallString.length()) {
                    result.add(true);
                    break;
                }
                j=0;

            }
            if (j != smallString.length()) {
                result.add(false);
            }
        }

        return result;
    }


    // O(b^2 +ns) time | O(b^2 + n ) space
    // where b is the length of the bigString
    // n is the number of smallStrings
    // and s the longest size of smallest string
    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {

        List<Boolean> result = new ArrayList<>();
        SuffixTrie suffixTrie = new SuffixTrie(bigString);

        for (String small : smallStrings) {
            TrieNode tempRoot = suffixTrie.root;
            boolean isValid = true;
            for (int i = 0; i < small.length(); i++) {
                char character = small.charAt(i);
                TrieNode trieNode = tempRoot.children.get(character);
                if (trieNode == null) {
                    result.add(false);
                    isValid = false;
                    break;
                }
                tempRoot = trieNode;
            }
            if (isValid) {
                result.add(true);
            }
        }

        return result;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    static class SuffixTrie {

        TrieNode root = new TrieNode();
        Character endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrie(str);
        }

        public void populateSuffixTrie(String str) {

            for (int i = 0; i < str.length(); i++) {
                TrieNode node = root;
                for (int j = i; j < str.length(); j++) {
                    char characterAtStr = str.charAt(j);
                    if (!node.children.containsKey(characterAtStr)) {
                        node.children.put(characterAtStr, new TrieNode());
                    }
                    node = node.children.get(characterAtStr);
                }
                node.children.put(endSymbol, new TrieNode());
            }
        }

    }

}
