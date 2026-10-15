package com.chrzanop.coding.leetcode.string;
import java.util.ArrayList;
import java.util.List;

public class CartesianProductRecursive {

    public static <T> void checkAllCombinations(List<List<T>> collections) {
        generateCombinations(collections, 0, new ArrayList<>());
    }

    private static <T> void generateCombinations(List<List<T>> collections, int index, List<T> current) {
        if (index == collections.size()) {
            // Base case: process full combination
            processCombination(current);
            return;
        }

        List<T> currentCollection = collections.get(index);

        // Standard index-based for loop
        for (int i = 0; i < currentCollection.size(); i++) {
            T item = currentCollection.get(i);

            current.add(item);
            generateCombinations(collections, index + 1, current);
            current.remove(current.size() - 1); // Backtrack
        }

//        for (T item : collections.get(index)) {
//            System.out.println(item);
//            current.add(item);
//            generateCombinations(collections, index + 1, current);
//            current.remove(current.size() - 1); // Backtrack
//        }
    }

    private static <T> void processCombination(List<T> combination) {
        System.out.println(combination);
    }

    public static void main(String[] args) {
        List<List<Integer>> input = List.of(
                List.of(1, 2),
                List.of(10, 20),
                List.of(100, 200)
        );

        checkAllCombinations(input);
    }
}
