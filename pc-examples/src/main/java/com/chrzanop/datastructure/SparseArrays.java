package com.chrzanop.datastructure;

import java.util.*;

public class SparseArrays {


    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> matched = new ArrayList<>();

        Map<String, Integer> queriesH = new HashMap<>();
        for (String query : queries) {
            queriesH.put(query, 0);
        }

        for (String item : strings) {
            if (queriesH.containsKey(item)) {
                int value = queriesH.get(item);
                queriesH.put(item, ++value);
            }
        }

        for (String query : queries) {
            matched.add(queriesH.get(query));
        }

        return matched;

    }

    public static void main(String[] args) {
        List<String> inputStrings = Arrays.asList("ab", "ba", "ab");
        List<String> queries = Arrays.asList("ab", "bb", "ba");

        System.out.println(matchingStrings(inputStrings, queries));
    }


}
