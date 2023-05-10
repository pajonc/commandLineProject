package com.chrzanop.coding.algoexpert.string;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GroupAnagrams {

    // O(w * n * log(n)) time | O(wn) space - where w  is the number of words and n is the length of
    // the longest word
    public static List<List<String>> groupAnagrams_Algo2(List<String> words) {
        Map<String, List<String>> anagrams = new HashMap<String, List<String>>();
        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            if (anagrams.containsKey(sortedWord)) {
                anagrams.get(sortedWord).add(word);
            } else {
                anagrams.put(sortedWord, new ArrayList<String>(Arrays.asList(word)));
            }
        }
        return new ArrayList<>(anagrams.values());
    }

    // O (w * n * log(n) + n * w * log(w) )  time | O(wn) space - where w  is the number of words and n is the length of
    // the longest word
    public static List<List<String>> groupAnagrams_Algo1(List<String> words) {

        List<String> sortedWords = new ArrayList<>();
        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            sortedWords.add(sortedWord);
        }


        List<Integer> indices = IntStream.range(0, words.size()).boxed().collect(Collectors.toList());
        indices.sort((a, b) -> sortedWords.get(a).compareTo(sortedWords.get(b)));

        List<List<String>> result = new ArrayList<>();
        List<String> currentAnagramGroup = new ArrayList<>();
        String currentAnagram = sortedWords.get(indices.get(0));

        for (Integer index : indices) {
            String word = words.get(index);
            String sortedWord = sortedWords.get(index);

            if (sortedWord.equals(currentAnagram)) {
                currentAnagramGroup.add(word);
                continue;
            }
            result.add(currentAnagramGroup);
            currentAnagramGroup = new ArrayList<>(Arrays.asList(word));
            currentAnagram = sortedWord;
        }
        result.add(currentAnagramGroup);
        return result;
    }
}
