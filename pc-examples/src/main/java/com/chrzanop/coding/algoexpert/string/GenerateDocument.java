package com.chrzanop.coding.algoexpert.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class GenerateDocument {

    @Test
    public void TestCase1() {
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";
        boolean expected = true;
        boolean actual = new GenerateDocument().generateDocument(characters, document);
        boolean actual2 = new GenerateDocument().generateDocument2(characters, document);
        assertTrue(expected == actual);
        assertTrue(expected == actual2);
    }


    // O(n+m) time | O(c) space - where c is the number of unique characters in the characters string,
    // n - number of characters, m is the length of the document
    public boolean generateDocument2(String characters, String document) {
        Map<Character,Integer> characterCounts = new HashMap<>();
        for(int i=0;i<characters.length();i++) {
            char character = characters.charAt(i);
            characterCounts.put(character, characterCounts.getOrDefault(character, 0) + 1);
        }
        for(int i=0; i< document.length();i++) {
            char character = document.charAt(i);
            if(!characterCounts.containsKey(character) || characterCounts.get(character) == 0) {
                return false;
            }
            characterCounts.put(character, characterCounts.get(character) - 1);
        }
        return true;
    }


    // O(c*(n+m)) time| O(c) space - where n is the number of characters, m is the length of the document,
    // and c is the number of unique characters in the document
    public boolean generateDocument(String characters, String document) {
        Set<Character> counts = new HashSet<>();
        for (int i = 0; i < document.length(); i++) {
            char character = document.charAt(i);
            if (counts.contains(character)) {
                continue;
            }
            int countCharacterInDocument = countCharacterInString(document, character);
            int countCharacterInCharacters = countCharacterInString(characters,character);

            if (countCharacterInDocument > countCharacterInCharacters) {
                return false;
            }
            counts.add(character);
        }
        return true;
    }

    private int countCharacterInString(String document, char character) {
        int countCharacterInDocument = 0;
        for (int j = 0; j < document.length(); j++) {
            if (document.charAt(j) == character) {
                countCharacterInDocument++;
            }
        }
        return countCharacterInDocument;
    }

}
