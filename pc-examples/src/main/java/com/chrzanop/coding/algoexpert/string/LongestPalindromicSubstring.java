package com.chrzanop.coding.algoexpert.string;

public class LongestPalindromicSubstring {


    //O(n^2) time | O(n) space
    public static String longestPalindromicSubstring_Algo2(String str) {
        int[] currentLongest = {0,1};
        for (int i = 0; i < str.length(); i++) {
            int[] odd = getLongestPalindromeFrom(str, i-1, i+1);
            int[] even = getLongestPalindromeFrom(str, i-1, i);
            int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            currentLongest = currentLongest[1] - currentLongest[0] > longest[1] - longest[0]
                    ? currentLongest
                    : longest;
        }
        return str.substring(currentLongest[0], currentLongest[1]);
    }

    private static int[] getLongestPalindromeFrom(String str, int leftIdx, int rightIdx) {
        while (leftIdx>=0 && rightIdx < str.length()) {
            if(str.charAt(leftIdx) != str.charAt(rightIdx)) {
                break;
            }
            leftIdx--;
            rightIdx++;
        }
        return new int[] {leftIdx+1, rightIdx};
    }


    //O(n^2) time | O(n) space
    public static String longestPalindromicSubstring_Algo2_Mine(String str) {
        String longest = "";

        for (int i = 0; i < str.length(); i++) {
            String longestOdd = longestOddStringPalindrome(str, i);
            String longestEven = longestEvenPalindrome(str, i);
            String takeLongest = longestEven.length() > longestOdd.length() ? longestEven : longestOdd;
            if (takeLongest.length() > longest.length()) {
                longest = takeLongest;
            }
        }
        return longest;
    }

    private static String longestOddStringPalindrome(String str, int i) {
        if (i == str.length() - 1) {
            return str.substring(i, i + 1);
        }
        int leftIdx = i;
        int rightIdx = i + 1;
        if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
            return str.substring(leftIdx, rightIdx);
        }
        while (leftIdx >= 0 && rightIdx < str.length()) {
            if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
                break;
            }
            leftIdx -= 1;
            rightIdx += 1;

        }
        return str.substring(leftIdx + 1, rightIdx);
    }

    private static String longestEvenPalindrome(String str, int i) {
        int leftIdx = i;
        int rightIdx = i;
        while (leftIdx >= 0 && rightIdx < str.length()) {
            if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
                break;
            }
            leftIdx -= 1;
            rightIdx += 1;
        }
        return str.substring(leftIdx + 1, rightIdx);
    }

    //O(n^3) time | O(n) space
    public static String longestPalindromicSubstring_Algo1(String str) {
        String longest = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String substring = str.substring(i, j + 1);
                if (substring.length() > longest.length() && isPalindrome(substring)) {
                    longest = substring;
                }
            }
        }
        return longest;
    }


    private static boolean isPalindrome(String str) {
        int startIdx = 0;
        int endIdx = str.length() - 1;
        while (startIdx < endIdx) {
            if (str.charAt(startIdx) != str.charAt(endIdx)) {
                return false;
            }
            startIdx++;
            endIdx--;
        }
        return true;
    }

}
