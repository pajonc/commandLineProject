package com.chrzanop.coding.algoexpert.string;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {


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

}
