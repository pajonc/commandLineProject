package com.chrzanop.coding.algoexpert.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplication {

    public static String longestSubstringWithoutDuplication(String str) {
        String longestSubstring = "";
        int startIndex = 0, endIndex = 0;
        Map<Character, Integer> lastSeenCharacter = new HashMap<>();
        while (endIndex < str.length()) {
            char currentChar = str.charAt(endIndex);
            if (lastSeenCharacter.containsKey(currentChar)) {
                int charIndex =  lastSeenCharacter.get(currentChar);
                startIndex = Math.max(startIndex, charIndex + 1);
            }
            String newString = str.substring(startIndex, endIndex+1);
            lastSeenCharacter.put(currentChar, endIndex);
            if (newString.length() >= longestSubstring.length()) {
                longestSubstring = newString;
            }

            endIndex++;
        }
        return longestSubstring;
    }
}
