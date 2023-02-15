package com.chrzanop.coding.algoexpert.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class FirstNonRepeatingCharacter {

    @Test
    public void TestCase1() {
        String input = "abcdcaf";
        int expected = 1;
        int actual = firstNonRepeatingCharacter(input);
        assertTrue(expected == actual);
        int actual2 = firstNonRepeatingCharacterBruteForce(input);
        assertTrue(expected == actual2);
    }


    // O(n) time | O(1) - n size of length of input characters
    // space because the input string only has lowercase character of max size 26
    public int firstNonRepeatingCharacter(String string) {

        Map<Character, Integer> characterCounts = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            characterCounts.put(character, characterCounts.getOrDefault(character, 0) + 1);
        }
        for (int i = 0; i < string.length(); i++) {
            if (characterCounts.get(string.charAt(i)) == 1)
                return i;
        }
        return -1;
    }


    // O(n^2) time | O(1) - n size of length of input characters
    public int firstNonRepeatingCharacterBruteForce(String string) {

        for (int i = 0; i < string.length(); i++) {
            boolean foundDuplicate = false;
            for (int j = 0; j < string.length(); j++) {
                if(string.charAt(i) == string.charAt(j) && i != j) {
                    foundDuplicate = true;
                }
            }
            if(!foundDuplicate) return i;
        }
        return -1;
    }




}
