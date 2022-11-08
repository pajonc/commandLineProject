package com.chrzanop.datastructure;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int size = 1;
        Set<String> windows = new HashSet<>();

        char[] chars = s.toCharArray();

        int j = 0;
        String window = "";
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                window = String.valueOf(chars[i]);
                windows.add(window);
                continue;
            }
            while (window.contains(String.valueOf(chars[i]))) {
                j++;
                window = buildWindow(chars, j, i - 1);
            }
            window = buildWindow(chars, j, i);
            windows.add(window);
        }


        return size;

    }

    private static String buildWindow(char[] chars, int j, int i) {
        String window = "";
        for (int k = j; k <= i; k++) {
            window += String.valueOf(chars[k]);
        }
        return window;
    }

}
