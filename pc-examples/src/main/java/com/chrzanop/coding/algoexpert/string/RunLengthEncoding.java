package com.chrzanop.coding.algoexpert.string;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RunLengthEncoding {


    @Test
    public void TestCase1() {
        String input = "AAAAAAAAAAAAABBCCCCDD";
        String expected = "9A4A2B4C2D";
        String actual = runLengthEncoding(input);
        System.out.println(actual);
        assertTrue(expected.equals(actual));
    }


    // O(n) time | O(n) space - where n is the length of the input string
    public static String runLengthEncoding(String string) {

        StringBuilder encodedStringCharacters = new StringBuilder();
        int currentRunLength = 1;

        for(int i=1;i<string.length();i++) {
            char previousCharacter = string.charAt(i-1);
            char currentCharacter = string.charAt(i);

            if((previousCharacter!=currentCharacter) || currentRunLength==9) {
                encodedStringCharacters.append(Integer.toString(currentRunLength));
                encodedStringCharacters.append(previousCharacter);
                currentRunLength = 0;
            }
            currentRunLength +=1;
        }
        encodedStringCharacters.append(currentRunLength);
        encodedStringCharacters.append(string.charAt(string.length()-1));
        return encodedStringCharacters.toString();
    }



//    public static String runLengthEncoding(String string) {
//
//        StringBuilder encoding = new StringBuilder();
//        String[] stringTable = string.split("");
//        int currentWindow = 1;
//        String previousValue = stringTable[0];
//        for(int i=1;i<string.length();i++) {
//            String currentValue = stringTable[i];
//            if(currentValue.equals(previousValue) && currentWindow < 9 ) {
//                currentWindow +=1;
//                continue;
//            } else {
//                encoding.append(currentWindow+previousValue);
//                previousValue = currentValue;
//                currentWindow = 1;
//            }
//        }
//        encoding.append(currentWindow+previousValue);
//
//        return encoding.toString();
//    }
}
