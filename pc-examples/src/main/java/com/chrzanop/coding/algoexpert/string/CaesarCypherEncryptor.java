package com.chrzanop.coding.algoexpert.string;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CaesarCypherEncryptor {

    @Test
    public void TestCase1() {
        assertTrue(caesarCypherEncryptor("xyz", 2).equals("zab"));
        assertTrue(caesarCypherEncryptor2("xyz", 2).equals("zab"));
    }

    // O(n) time | O(n) space
    public static String caesarCypherEncryptor(String str, int key) {
        char[] newLetters = new char[str.length()];
        int newKey = key % 26;
        for (int i = 0; i < str.length(); i++) {
            newLetters[i] = getNewLetter(str.charAt(i), newKey);
        }
        return new String(newLetters);
    }

    private static char getNewLetter(char letter, int key) {
        int newLetterCode = (int) letter + key;
        return newLetterCode <= 122 ? (char) newLetterCode : (char) (96 + newLetterCode % 122);
    }

    // O(n) time | O(n) space
    public static String caesarCypherEncryptor2(String str, int key) {
        char[] newLetters = new char[str.length()];
        int newKey = key % 26;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < str.length(); i++) {
            newLetters[i] = getNewLetter2(str.charAt(i), newKey, alphabet);
        }
        return new String(newLetters);
    }

    private static char getNewLetter2(char letter, int key, String alphabet) {
        int newLetterCode = alphabet.indexOf(letter) + key;
        return alphabet.charAt(newLetterCode % 26);
    }


}
