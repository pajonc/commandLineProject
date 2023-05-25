package com.chrzanop.coding.algoexpert.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInString {

    // O(n) time | O(n) space - where n is the length of the string
    public String reverseWordsInString(String string) {
        List<String> words = new ArrayList<>();
        int startOfWord = 0;

        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character == ' ') {
                if (startOfWord < i) {
                    words.add(string.substring(startOfWord, i));
                }
                words.add(" ");
                startOfWord = i + 1;
            }
        }
        if (startOfWord < string.length()) {
            words.add(string.substring(startOfWord, string.length()));
        }

        StringBuilder builderStr = new StringBuilder();
        for (int i = words.size() - 1; i >= 0; i--) {
            builderStr.append(words.get(i));
        }

        return builderStr.toString();
    }

    // O(n) time | O(n) space - where n is the length of the string
    public String reverseWordsInString_Algo1(String string) {
        ArrayList<String> words = new ArrayList<>();
        int startOfWord = 0;

        for (int idx = 0; idx < string.length(); idx++) {
            char character = string.charAt(idx);

            if (character == ' ') {
                words.add(string.substring(startOfWord, idx));
                startOfWord = idx;
            } else if (string.charAt(startOfWord) == ' ') {
                words.add(" ");
                startOfWord = idx;
            }

        }

        words.add(string.substring(startOfWord));

        Collections.reverse(words);
        return String.join("", words);

    }

    // O(n) time | O(n) space - where n is the length of the string
    public String reverseWordsInString_Algo2(String string) {
        char[] characters = string.toCharArray();
        reverseListRange(characters, 0, characters.length - 1);

        int startOfWord = 0;
        while (startOfWord < characters.length) {
            int endOfWord = startOfWord;
            while (endOfWord < characters.length && characters[endOfWord] != ' ') {
                endOfWord += 1;
            }
            reverseListRange(characters, startOfWord, endOfWord - 1);
            startOfWord = endOfWord + 1;
        }

        return new String(characters);
    }

    private char[] reverseListRange(char[] list, int start, int end) {
        while (start < end) {
            char temp = list[start];
            list[start] = list[end];
            list[end] = temp;
            start++;
            end--;

        }
        return list;
    }


}
