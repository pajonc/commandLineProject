package com.chrzanop.coding.algoexpert.string;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class Semordnilap {


    @Test
    public void TestCase1() {
        String[] input = new String[] {"desserts", "stressed", "hello"};
        ArrayList<ArrayList<String>> expected = new ArrayList<ArrayList<String>>();
        ArrayList<String> pair = new ArrayList<String>();
        pair.add("desserts");
        pair.add("stressed");
        expected.add(pair);
        ArrayList<ArrayList<String>> actual = semordnilap(input);
        assertTrue(expected.equals(actual));
    }


    // O(n*m) time | O(n*m) space - where n is number of words and m is the length of the longest word
    public ArrayList<ArrayList<String>> semordnilap(String[] words) {

        ArrayList<ArrayList<String>> semordinlapPairs = new ArrayList<ArrayList<String>>();
        Set<String> wordsSet = new HashSet<String>(Arrays.asList(words));

        for (int i = 0; i < words.length; i++) {
            String reverseWord = new StringBuilder(words[i]).reverse().toString();
            if (wordsSet.contains(reverseWord) && !reverseWord.equals(words[i])) {
                ArrayList<String> semordinlapPair = new ArrayList<String>();
                semordinlapPair.add(words[i]);
                semordinlapPair.add(reverseWord);
                semordinlapPairs.add(semordinlapPair);
                wordsSet.remove(words[i]);
                wordsSet.remove(reverseWord);
            }
        }

        return semordinlapPairs;
    }
}
