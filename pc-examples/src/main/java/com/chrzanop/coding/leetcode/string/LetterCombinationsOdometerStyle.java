package com.chrzanop.coding.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOdometerStyle {

    public static void letterCombinations(String digits) {

        Map<Character, List<String>> mapping = new HashMap();

        mapping.put('2', List.of("a", "b", "c"));
        mapping.put('3', List.of("d", "e", "f"));
        mapping.put('4', List.of("g", "h", "i"));
        mapping.put('5', List.of("j", "k", "l"));
        mapping.put('6', List.of("m", "n", "o"));
        mapping.put('7', List.of("p", "q", "r", "s"));
        mapping.put('8', List.of("t", "u", "v"));
        mapping.put('9', List.of("w", "x", "y", "z"));
        List<List<String>> combinations = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            combinations.add(mapping.get(digits.charAt(i)));
        }

        checkAllCombinations(combinations);
    }

    public static <T> void checkAllCombinations(List<List<T>> collections) {
        if (collections == null || collections.isEmpty()) return;

        int n = collections.size();
        int[] indices = new int[n];

        List<T> currentCombination = new ArrayList<>();

        while (true) {

            for (int i = 0; i < n; i++) {
                List<T> ts = collections.get(i);
                currentCombination.add(ts.get(indices[i]));
            }
            // view created combination
            System.out.println(currentCombination);
            currentCombination = new ArrayList<>();

            // odometer style
            int position = n - 1;
            while (position >= 0) {
                indices[position]++;
                if (indices[position] < collections.get(position).size()) {
                    break;
                }
                // reset current index and carry over
                indices[position] = 0;
                position--;
            }

            if (position < 0) {
                return;
            }
        }

    }


    public static void main(String[] args) {
        List<List<String>> input = List.of(
                List.of("A1", "A2"),
                List.of("B1", "B2"),
                List.of("C1", "C2")
        );

//        checkAllCombinations(input);

        letterCombinations("23");
    }
}
