package com.chrzanop.coding.algoexpert.string;

import java.util.*;

public class CommonCharacters {


    // O(n*m) time | O(c) space - where n is the number of strings,
    // m is the length of the longest string,
    // and c is the number of unique characters across all strings
    public String[] commonCharacters_Algo1(String[] strings) {
        int requiredOccurence = strings.length;
        Map<Character, Integer> charactersCount = new HashMap<>();
        for (String el : strings) {
            Set<Character> uniqueStringCharacters = new HashSet<>();
            for (int i = 0; i < el.length(); i++) {
                uniqueStringCharacters.add(el.charAt(i));
            }

            for (char character : uniqueStringCharacters) {
                if (!charactersCount.containsKey(character)) {
                    charactersCount.put(character, 0);
                }
                charactersCount.put(character, charactersCount.get(character) + 1);
            }
        }

        List<Character> finalCharacters = new ArrayList<>();
        Set<Map.Entry<Character, Integer>> entries = charactersCount.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            Character character = entry.getKey();
            Integer count = entry.getValue();
            if (count == requiredOccurence) {
                finalCharacters.add(character);
            }
        }

        String[] finalCharactersArr = new String[finalCharacters.size()];
        for (int i = 0; i < finalCharacters.size(); i++) {
            finalCharactersArr[i] = finalCharacters.get(i).toString();
        }


        return finalCharactersArr;
    }

    // O(n*m) time | O(m) space - where n is the number of strings,
    // m is the length of the longest string
    public String[] commonCharacters_Algo2(String[] strings) {
        String smallestString = getSmallestString(strings);
        Set<Character> potentialCommonCharacters = new HashSet<>();
        for (int i = 0; i < smallestString.length(); i++) {
            potentialCommonCharacters.add(smallestString.charAt(i));
        }

        for (String string : strings) {
            removeNonexistentCharacters(string, potentialCommonCharacters);
        }

        String[] output = new String[potentialCommonCharacters.size()];
        int i = 0;
        for (Character character : potentialCommonCharacters) {
            output[i] = character.toString();
            i++;
        }
        return output;
    }

    private String getSmallestString(String[] strings) {
        String smallestString = strings[0];
        for (String string : strings) {
            if (string.length() < smallestString.length()) {
                smallestString = string;
            }
        }
        return smallestString;
    }

    private void removeNonexistentCharacters(String str, Set<Character> potentialCommonCharacters) {
        Set<Character> uniqueStringCharacters = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            uniqueStringCharacters.add(str.charAt(i));
        }
        Set<Character> charactersToRemove = new HashSet<>();
        for (char character : potentialCommonCharacters) {
            if (!uniqueStringCharacters.contains(character)) {
                charactersToRemove.add(character);
            }
        }

        for (char character : charactersToRemove) {
            potentialCommonCharacters.remove(character);
        }
    }

}
