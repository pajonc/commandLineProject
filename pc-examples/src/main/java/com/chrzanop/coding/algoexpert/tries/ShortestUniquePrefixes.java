package com.chrzanop.coding.algoexpert.tries;

import java.util.HashMap;
import java.util.Map;

public class ShortestUniquePrefixes {

    public String[] shortestUniquePrefixes(String[] strings) {
        SuffixTrie suffixTrie = new SuffixTrie(strings);
        return suffixTrie.buildShortestUniquePrefixesBasedOnTrie();
    }

    static class TrieNode {

        Map<Character, TrieNode> children = new HashMap<>();
        int count = 0;
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        String[] strings;

        public SuffixTrie(String[] strings) {
            this.strings = strings;
            populateSuffixTrie(strings);
        }

        private void populateSuffixTrie(String[] strings) {
            for (String str : strings) {
                TrieNode node = root;
                for (int i = 0; i < str.length(); i++) {
                    char character = str.charAt(i);
                    if (!node.children.containsKey(character)) {
                        TrieNode newNode = new TrieNode();
                        node.children.put(character, newNode);
                    }
                    node = node.children.get(character);
                    node.count++;
                }
            }
        }

        public String[] buildShortestUniquePrefixesBasedOnTrie() {
            String[] shortestUniquePrefixes = new String[this.strings.length];
            int indexShortestUniquePrefixes = 0;
            for (String str : this.strings) {
                TrieNode node = root;
                StringBuilder prefixBuilder = new StringBuilder();
                for (int i = 0; i < str.length(); i++) {
                    node = node.children.get(str.charAt(i));
                    prefixBuilder.append(str.charAt(i));
                    if (node.count == 1) {
                        break;
                    }
                }
                shortestUniquePrefixes[indexShortestUniquePrefixes] = prefixBuilder.toString();
                indexShortestUniquePrefixes++;
            }
            return shortestUniquePrefixes;
        }

    }
}
