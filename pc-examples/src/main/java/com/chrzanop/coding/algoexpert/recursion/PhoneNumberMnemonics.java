package com.chrzanop.coding.algoexpert.recursion;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class PhoneNumberMnemonics {

    @Test
    public void TestCase1() {
        String phoneNumber = "1905";
        String[] expectedValues =
                new String[] {
                        "1w0j", "1w0k", "1w0l", "1x0j", "1x0k", "1x0l", "1y0j", "1y0k", "1y0l", "1z0j", "1z0k",
                        "1z0l"
                };
        ArrayList<String> expected = new ArrayList<String>();
        for (int i = 0; i < expectedValues.length; i++) {
            expected.add(expectedValues[i]);
        }
        ArrayList<String> actualWords = new PhoneNumberMnemonics().phoneNumberMnemonics(phoneNumber);
        assertTrue(expected.equals(actualWords));
    }

    public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {

        Map<String, List<String>> mappingDigitsToLetters = new HashMap<>();
        mappingDigitsToLetters.put("1", Arrays.asList("1"));
        mappingDigitsToLetters.put("2", Arrays.asList("a","b","c"));
        mappingDigitsToLetters.put("3", Arrays.asList("d","e","f"));
        mappingDigitsToLetters.put("4", Arrays.asList("g","h","i"));
        mappingDigitsToLetters.put("5", Arrays.asList("j","k","l"));
        mappingDigitsToLetters.put("6", Arrays.asList("m","n","o"));
        mappingDigitsToLetters.put("7", Arrays.asList("p","q","r","s"));
        mappingDigitsToLetters.put("8", Arrays.asList("t","u","v"));
        mappingDigitsToLetters.put("9", Arrays.asList("w","x","y","z"));
        mappingDigitsToLetters.put("0", Arrays.asList("0"));

        String[] digits = phoneNumber.split("[//d]*");

        return phoneNumberMnemonics(digits, mappingDigitsToLetters, new ArrayList<String>(), "", 0);
    }


    private ArrayList<String> phoneNumberMnemonics(String[] digits, Map<String, List<String>> mappingDigitsToLetters, ArrayList<String> words, String currentWord, int idx ) {

        if( currentWord.length() == digits.length ) {
            words.add(currentWord);
            return words;
        }

        List<String> mappedLetters = mappingDigitsToLetters.get(digits[idx]);

        for(String letter : mappedLetters) {
            idx++;
            String newCurrentWord = currentWord + letter;
            phoneNumberMnemonics(digits,mappingDigitsToLetters, words,newCurrentWord,idx);
            idx--;
        }

        return words;
    }

}
