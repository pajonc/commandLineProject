package com.chrzanop.coding.algoexpert.string;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class GenerateDocument {

    @Test
    public void TestCase1() {
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";
        boolean expected = true;
        boolean actual = new GenerateDocument().generateDocument(characters, document);
        assertTrue(expected == actual);
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
