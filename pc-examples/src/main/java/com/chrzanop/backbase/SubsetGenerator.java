package com.chrzanop.backbase;

import java.util.ArrayList;
import java.util.List;

public class SubsetGenerator {
    public static void main(String[] args) {
        String str = "ab";
        List<String> subsets = generateSubsets(str);
        System.out.println(subsets);
    }

    public static List<String> generateSubsets(String s) {
        List<String> result = new ArrayList<>();
        generateSubsetsHelper(s, "", result);
        return result;
    }

    private static void generateSubsetsHelper(String s, String current, List<String> result) {
        if (s.length() == 0) {
            result.add(current);
            return;
        }

        // Include the first character
        generateSubsetsHelper(s.substring(1), current + s.charAt(0), result);

        // Exclude the first character
        generateSubsetsHelper(s.substring(1), current, result);
    }
}
