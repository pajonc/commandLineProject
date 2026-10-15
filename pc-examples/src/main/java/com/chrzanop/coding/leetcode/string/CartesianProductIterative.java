package com.chrzanop.coding.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class CartesianProductIterative {

    public static <T> void checkAllCombinations(List<List<T>> collections) {
        if (collections == null || collections.isEmpty()) return;

        int n = collections.size();
        int[] indices = new int[n];

        while (true) {
            // 1. Construct current combination
            List<T> currentCombination = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                currentCombination.add(collections.get(i).get(indices[i]));
            }

            // 2. Process / check your combination here
            processCombination(currentCombination);

            // 3. Advance indices to next combination (Odometer style)
            int position = n - 1;
            while (position >= 0) {
                indices[position]++;
                if (indices[position] < collections.get(position).size()) {
                    break; // Moved to next valid combination
                }
                indices[position] = 0; // Reset current index and carry over
                position--;
            }

            // Completed all combinations
            if (position < 0) {
                break;
            }
        }
    }

    private static <T> void processCombination(List<T> combination) {
        System.out.println(combination);
    }

    public static void main(String[] args) {
        List<List<String>> input = List.of(
                List.of("A1", "A2"),
                List.of("B1", "B2"),
                List.of("C1", "C2")
        );

        checkAllCombinations(input);
    }
}
