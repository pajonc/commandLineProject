package com.chrzanop.coding.algoexpert.tries;

import java.util.HashMap;
import java.util.Map;

public class SuffixTrieMain {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        //O(n^2) time | O(n^2) space
        public void populateSuffixTrieFrom(String str) {
            for (int i = 0; i < str.length(); i++) {
                insertSubstringStartingAt(i, str);
            }
        }

        private void insertSubstringStartingAt(int i, String str) {
            TrieNode node = root;
            for (int j = i; j < str.length(); j++) {
                char letter = str.charAt(j);
                if(!node.children.containsKey(letter)) {
                    TrieNode newTrieNode = new TrieNode();
                    node.children.put(letter, newTrieNode);
                }
                node = node.children.get(letter);
            }
            node.children.put(endSymbol, null);
        }

        public boolean contains(String str) {
            TrieNode node = root;
            for (int i = 0; i < str.length(); i++) {
                char key = str.charAt(i);
                if(!node.children.containsKey(key)) {
                    return false;
                }
                node = node.children.get(key);
            }
            return node.children.containsKey(endSymbol);
        }
    }
}

