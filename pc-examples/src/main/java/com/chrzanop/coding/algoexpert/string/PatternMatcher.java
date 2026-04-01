package com.chrzanop.coding.algoexpert.string;

import java.util.HashMap;
import java.util.Map;

public class PatternMatcher {

    // O(n^2 + m) time | O(n + m) space - where n is the length of the pattern and m is the length of the string
    public static String[] patternMatcherAlgo(String pattern, String str) {
        if (pattern.length() > str.length()) {
            return new String[]{};
        }
        char[] newPattern = getNewPattern(pattern);
        boolean didSwitch = newPattern[0] != pattern.charAt(0);
        Map<Character, Integer> counts = new HashMap<>();
        counts.put('x', 0);
        counts.put('y', 0);
        int firstYPos = getCountsAndFirstYPos(newPattern, counts);
        if (counts.get('y') != 0) {
            for (int lenOfX = 1; lenOfX < str.length(); lenOfX++) {
                double lenOfY = ((double) str.length() - (double) lenOfX * (double) counts.get('x')) / (double) counts.get('y');
                if (lenOfY <= 0 || lenOfY % 1 != 0) {
                    continue;
                }
                int yIdx = firstYPos * lenOfX;
                String x = str.substring(0, lenOfX);
                String y = str.substring(yIdx, yIdx + (int) lenOfY);
                String potentialMatch = buildPotentialMatch(newPattern, x, y);
                if (str.equals(potentialMatch)) {
                    return didSwitch ? new String[]{y, x} : new String[]{x, y};
                }
            }
        } else {
            double lenOfX = str.length() / counts.get('x');
            if (lenOfX % 1 == 0) {
                String x = str.substring(0, (int) lenOfX);
                String potentialMatch = buildPotentialMatch(newPattern, x, "");
                if (str.equals(potentialMatch)) {
                    return didSwitch ? new String[]{"", x} : new String[]{x, ""};
                }
            }
        }

        return new String[]{};
    }

    private static String buildPotentialMatch(char[] newPattern, String x, String y) {
        StringBuilder potentialMatch = new StringBuilder();
        for (char c : newPattern) {
            if (c == 'x') {
                potentialMatch.append(x);
            } else {
                potentialMatch.append(y);
            }
        }
        return potentialMatch.toString();
    }

    private static int getCountsAndFirstYPos(char[] newPattern, Map<Character, Integer> counts) {
        int firstYPos = -1;
        for (int i = 0; i < newPattern.length; i++) {
            char c = newPattern[i];
            counts.put(c, counts.get(c) + 1);
            if (c == 'y' && firstYPos == -1) {
                firstYPos = i;
            }
        }
        return firstYPos;
    }

    private static char[] getNewPattern(String pattern) {
        char[] patternLetters = pattern.toCharArray();
        if (pattern.charAt(0) == 'x') {
            return patternLetters;
        }
        for (int i = 0; i < patternLetters.length; i++) {
            if (patternLetters[i] == 'x') {
                patternLetters[i] = 'y';
            } else {
                patternLetters[i] = 'x';
            }
        }
        return patternLetters;
    }

    // O(n^2 + m) time | O(n + m) space - where n is the length of the pattern and m is the length of the string
    public static String[] patternMatcher(String pattern, String str) {

        String patternAdjusted = adjustPattern(pattern);
        CountsAndFirstYPos countsAndFirstYPos = getCountsAndFirstYPos(patternAdjusted);

        if (countsAndFirstYPos.countOfY != 0) {
            for (int lengthOfX = 1; lengthOfX < str.length(); lengthOfX++) {
                int lengthOfY = (str.length() - lengthOfX * countsAndFirstYPos.countOfX) / countsAndFirstYPos.countOfY;
                if (lengthOfY <= 0 || lengthOfY % 1 != 0) {
                    continue;
                }
                String strX = str.substring(0, lengthOfX);
                int beginIndexOfY = lengthOfX * countsAndFirstYPos.firstYPos;
                String strY = str.substring(beginIndexOfY, beginIndexOfY + lengthOfY);
                StringBuilder stringBuilder = new StringBuilder();
                for (char element : patternAdjusted.toCharArray()) {
                    stringBuilder.append(element == 'x' ? strX : strY);
                }
                if (str.equals(stringBuilder.toString())) {
                    return new String[]{strX, strY};
                }
            }
        }

        return new String[]{};
    }

    private static CountsAndFirstYPos getCountsAndFirstYPos(String patternAdjusted) {
        int countOfX = 0;
        int countOfY = 0;
        int firstYPos = -1;
        for (int i = 0; i < patternAdjusted.length(); i++) {
            char c = patternAdjusted.charAt(i);
            if (c == 'x') {
                countOfX++;
            } else {
                countOfY++;
                if (firstYPos == -1) {
                    firstYPos = i;
                }
            }
        }
        return new CountsAndFirstYPos(countOfX, countOfY, firstYPos);
    }

    private static String adjustPattern(String pattern) {

        if (pattern.charAt(0) == 'x') {
            return pattern;
        } else {
            StringBuilder sb = new StringBuilder();
            for (char c : pattern.toCharArray()) {
                if (c == 'x') {
                    sb.append('y');
                } else {
                    sb.append('x');
                }
            }
            return sb.toString();
        }

    }

    static class CountsAndFirstYPos {
        int countOfX;
        int countOfY;
        int firstYPos;

        public CountsAndFirstYPos(int countOfX, int countOfY, int firstYPos) {
            this.countOfX = countOfX;
            this.countOfY = countOfY;
            this.firstYPos = firstYPos;
        }
    }
}
