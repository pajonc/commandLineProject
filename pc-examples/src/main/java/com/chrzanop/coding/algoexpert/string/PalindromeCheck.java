package com.chrzanop.coding.algoexpert.string;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PalindromeCheck {

    @Test
    public void shouldPassTestCase1() {
        assertTrue(isPalindrome("abcdcba"));
    }

    @Test
    public void shouldPassTestCase2() {
        assertTrue(isPalindromeRec("abcdcba"));
    }

    @Test
    public void shouldPassTestCase3() {
        assertTrue(isPalindromeReverse("abcdcba"));
    }


    // O(n) time | O(1) space
    public static boolean isPalindrome(String str) {
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

    // O(n) time | O(n) space
    public static boolean isPalindromeRec(String str) {
        return isPalindromeRec(str, 0);
    }

    public static boolean isPalindromeRec(String str, int i) {
        int j = str.length() - 1 - i;
        return i >= j ? true : str.charAt(i) == str.charAt(j) && isPalindromeRec(str, i + 1);
    }

    // O(n) time | O(n) space
    public static boolean isPalindromeReverse(String str) {
        StringBuilder reversedString = new StringBuilder();
        int j = 0;
        for (int i = str.length()-1; i >= 0 ; i--) {
            reversedString.append(str.charAt(i));
        }
        for (int i = 0; i < 10; i++) {

        }
        return str.equals(reversedString.toString());
    }

    /**
        public static boolean isPalindromeRec2(String str, int i) {
            int j = str.length() -1 - i;
            if(i>=j) {
                return true;
            }
            if(str.charAt(i)!=str.charAt(j)) {
                return false;
            }
            return isPalindromeRec2(str, i + 1);
        }
    */


}
