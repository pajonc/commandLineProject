package com.chrzanop.coding.algoexpert.string;

import java.util.ArrayList;
import java.util.List;

public class UnderscorifySubstring {

    // Average case: O(n+m) time | O(n) space - where n is the length of the
    // main string and m is the lenght of the substring
    public static String underscorifySubstring(String str, String substring) {
        return underscorify(str, collapse(getLocations(str, substring)));
    }

    private static List<Integer[]> getLocations(String str, String substring) {
        List<Integer[]> locations = new ArrayList<>();
        int startIdx = 0;
        while (startIdx < str.length()) {
            int nextIdx = str.indexOf(substring, startIdx);
            if (nextIdx != -1) {
                locations.add(new Integer[]{nextIdx, nextIdx + substring.length()});
                startIdx = nextIdx + 1;
            } else {
                break;
            }
        }
        return locations;
    }

    private static List<Integer[]> collapse(List<Integer[]> locations) {
        if (locations.size() == 0) {
            return locations;
        }
        List<Integer[]> newLocations = new ArrayList<>();
        newLocations.add(locations.get(0));
        Integer[] previous = newLocations.get(0);
        for (int i = 1; i < locations.size(); i++) {
            Integer[] current = locations.get(i);
            if (current[0] <= previous[1]) {
                previous[1] = current[1];
            } else {
                newLocations.add(current);
                previous = current;
            }
        }
        return newLocations;
    }

    private static String underscorify(String str, List<Integer[]> locations) {
        int stringIndex = 0;
        int locationIndex = 0;
        List<String> finalChars = new ArrayList<>();
        boolean inBetweenUnderscores = false;
        int i = 0;
        while (stringIndex < str.length() && locationIndex < locations.size()) {
            if (stringIndex == locations.get(locationIndex)[i]) {
                finalChars.add("_");
                inBetweenUnderscores = !inBetweenUnderscores;
                if (!inBetweenUnderscores) {
                    locationIndex++;
                }
                i = i == 1 ? 0 : 1;
            }
            finalChars.add(String.valueOf(str.charAt(stringIndex)));
            stringIndex += 1;
        }
        if (locationIndex < locations.size()) {
            finalChars.add("_");
        } else if (stringIndex < str.length()) {
            finalChars.add(str.substring(stringIndex));
        }

        return String.join("", finalChars);
    }
}
