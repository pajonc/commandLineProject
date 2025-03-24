package com.chrzanop.coding.algoexpert.tries;

import java.util.HashMap;
import java.util.Map;

public class LongestMostFrequentPrefix {

    // O(n * m) time | O(n*m) space - where n is the length of strings, and m
    // is the length of the longest string
    public String longestMostFrequentPrefix(String[] strings) {
        SuffixTrie suffixTrie = new SuffixTrie(strings);
        return suffixTrie.getPrefix();
    }


    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count = 0;

        public TrieNode(int count) {
            this.count = count;
        }

        public TrieNode() {
        }
    }

    static class SuffixTrie {

        TrieNode root = new TrieNode(0);
        int maxPrefixCount = 0;
        int maxPrefixLength = 0;
        String maxPrefixFullStr = "";

        public SuffixTrie(String[] strings) {
            populateTrie(strings);
        }

        void populateTrie(String[] strings) {
            for (String str : strings) {
                TrieNode node = root;
                for (int i = 0; i < str.length(); i++) {
                    char character = str.charAt(i);
                    if (!node.children.containsKey(character)) {
                        node.children.put(character, new TrieNode());
                    }
                    node = node.children.get(character);
                    node.count++;
                    if(node.count > this.maxPrefixCount) {
                        maxPrefixCount = node.count;
                        maxPrefixFullStr = str;
                        maxPrefixLength = i + 1;
                    } else if(node.count == maxPrefixCount && i+1>maxPrefixLength) {
                        maxPrefixLength = i + 1;
                        this.maxPrefixFullStr = str;
                    }
                }
            }
        }
// my own working version
//        void populateTrie(String[] strings) {
//            for (String str : strings) {
//                TrieNode node = root;
//                int tempMaxPrefixLength = 0;
//                for (int i = 0; i < str.length(); i++) {
//                    char character = str.charAt(i);
//                    if (!node.children.containsKey(character)) {
//                        int count = 1;
//                        tempMaxPrefixLength = tempMaxPrefixLength + 1;
//                        node.children.put(character, new TrieNode(count));
//                        if (maxPrefixCount < count) {
//                            maxPrefixCount = count;
//                            maxPrefixFullStr = str;
//                        }
//                        if (tempMaxPrefixLength > maxPrefixLength && maxPrefixCount <= count) {
//                            maxPrefixLength = tempMaxPrefixLength;
//                            maxPrefixFullStr = str;
//                        }
//                    } else {
//                        TrieNode trieNode = node.children.get(character);
//                        trieNode.count += 1;
//                        tempMaxPrefixLength = tempMaxPrefixLength + 1;
//                        if (maxPrefixCount < trieNode.count) {
//                            maxPrefixCount = trieNode.count;
//                            maxPrefixLength = tempMaxPrefixLength;
//                            maxPrefixFullStr = str;
//                        }
//                        if(maxPrefixLength<tempMaxPrefixLength) {
//                            maxPrefixLength = tempMaxPrefixLength;
//                        }
//                    }
//                    node = node.children.get(character);
//                }
//            }
//        }

        public String getPrefix() {
            return maxPrefixFullStr.substring(0, maxPrefixLength);
        }

    }
}
