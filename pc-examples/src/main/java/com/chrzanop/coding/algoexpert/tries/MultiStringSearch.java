package com.chrzanop.coding.algoexpert.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiStringSearch {

    // O(b^2 +ns) time | O(b^2 + n ) space
    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {

        List<Boolean> result = new ArrayList<>();
        SuffixTrie suffixTrie = new SuffixTrie(bigString);

        for (String small : smallStrings) {
            TrieNode tempRoot = suffixTrie.root;
            boolean isValid = true;
            for (int i = 0; i < small.length(); i++) {
                char character = small.charAt(i);
                TrieNode trieNode = tempRoot.children.get(character);
                if(trieNode == null) {
                    result.add(false);
                    isValid = false;
                    break;
                }
                tempRoot = trieNode;
            }
            if(isValid) {
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
