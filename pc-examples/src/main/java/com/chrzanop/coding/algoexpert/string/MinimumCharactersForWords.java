package com.chrzanop.coding.algoexpert.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinimumCharactersForWords {

    // O(n * l) time | O(c) space - where n is the number of words,
    // l is the length of the longest word, and c is the number of
    // unique characters across all words
    public char[] minimumCharactersForWords(String[] words) {
        Map<Character, Integer> maximumCharacterFrequencies = new HashMap<>();

        for (String word : words) {
            Map<Character, Integer> characterFrequencies = countCharacterFrequencies(word);
            updateMaximumFrequencies(characterFrequencies, maximumCharacterFrequencies);
        }

        return makeArrayFromCharacterFrequencies(maximumCharacterFrequencies);
    }

    private Map<Character, Integer> countCharacterFrequencies(String string) {
        Map<Character, Integer> characterFrequencies = new HashMap<>();

        for (char character : string.toCharArray()) {
            characterFrequencies.put(character, characterFrequencies.getOrDefault(character, 0) + 1);
        }
        return characterFrequencies;
    }

    private void updateMaximumFrequencies(Map<Character, Integer> frequencies, Map<Character, Integer> maximumFrequencies) {

        for (Map.Entry<Character, Integer> frequency : frequencies.entrySet()) {
            char character = frequency.getKey();
            int characterFrequency = frequency.getValue();
            if (maximumFrequencies.containsKey(character)) {
                maximumFrequencies.put(
                        character, Math.max(characterFrequency, maximumFrequencies.get(character)));
            } else {
                maximumFrequencies.put(character, characterFrequency);
            }
        }
    }


    private char[] makeArrayFromCharacterFrequencies(Map<Character, Integer> characterFrequencies) {
        ArrayList<Character> characters = new ArrayList<>();

        for (Map.Entry<Character, Integer> frequency : characterFrequencies.entrySet()) {
            char character = frequency.getKey();
            int characterFrequency = frequency.getValue();

            for (int i = 0; i < characterFrequency; i++) {
                characters.add(character);
            }
        }

        char[] charactersArray = new char[characters.size()];
        for (int idx = 0; idx < characters.size(); idx++) {
            charactersArray[idx] = characters.get(idx);
        }

        return charactersArray;
    }

}
