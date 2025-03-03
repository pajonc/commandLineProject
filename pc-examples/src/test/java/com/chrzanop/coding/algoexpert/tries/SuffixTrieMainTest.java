package com.chrzanop.coding.algoexpert.tries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuffixTrieMainTest {


    @Test
    public void TestCase1() {
        var trie = new SuffixTrieMain.SuffixTrie("babc");
        assertTrue(trie.contains("abc"));
    }

}