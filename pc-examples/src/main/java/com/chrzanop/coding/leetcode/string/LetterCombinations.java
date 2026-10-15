package com.chrzanop.coding.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();

        System.out.println(letterCombinations.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {

        Map<Character,List<String>> mapping = new HashMap();

        mapping.put('2',List.of("a","b","c"));
        mapping.put('3',List.of("d","e","f"));
        mapping.put('4',List.of("g","h","i"));
        mapping.put('5',List.of("j","k","l"));
        mapping.put('6',List.of("m","n","o"));
        mapping.put('7',List.of("p","q","r","s"));
        mapping.put('8',List.of("t","u","v"));
        mapping.put('9',List.of("w","x","y","z"));
        List<List<String>> combinations = new ArrayList<>();

        for(int i=0;i<digits.length();i++) {
            combinations.add(mapping.get(digits.charAt(i)));
        }


        List<String> result = new ArrayList<>();
        processCombination(combinations, 0, new ArrayList<>(), result);

        return result;
    }

    private static void processCombination(List<List<String>> combinations, int index, List<String> currentCombination, List<String> result) {
        if(index == combinations.size()){
            result.add(String.join("", currentCombination));
            // System.out.println(currentCombination);
            return;
        }

        for(String item : combinations.get(index)) {
            currentCombination.add(item);
            processCombination(combinations, index +1, currentCombination, result);
            currentCombination.remove(currentCombination.size()-1); // backtrack
        }
    }

}
