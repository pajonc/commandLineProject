package com.chrzanop.coding.algoexpert.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {


    public static void main(String[] args) {
        longestCommonSubsequenceAlgoSimilar("abc","ac");

    }

    public static List<Character> longestCommonSubsequenceAlgoSimilar(String str1, String str2) {

        if(str1.length()==0 || str2.length()==0) {
            return new ArrayList<>();
        }

        str1 = " " + str1;
        str2 = " " + str2;
        String[][] multiDimensionalArray = new String[str1.length()][str2.length()];
        char[] charsStr1 = str1.toCharArray();
        char[] charsStr2 = str2.toCharArray();

        for (int i = 0; i < multiDimensionalArray.length; i++) {
            for (int j = 0; j < multiDimensionalArray[0].length; j++) {

                String sLeft = null;
                String sUp = null;
                String sDianogal = null;
                if(i-1>0 && j-1>0) {
                    sDianogal = multiDimensionalArray[i-1][j-1];
                }
                if(i-1>0) {
                    sLeft = multiDimensionalArray[i-1][j];
                }
                if(j-1>0) {
                    sUp = multiDimensionalArray[i][j-1];
                }

                if(charsStr1[i] == charsStr2[j]) {
                    if(sDianogal != null && sDianogal.length() > 0) {
                        multiDimensionalArray[i][j] = sDianogal + charsStr1[i];
                    } else {
                        multiDimensionalArray[i][j] = String.valueOf(charsStr1[i]);
                    }
                } else {
                    
                    if(sLeft!=null && sUp!=null) {
                        if(sLeft.length()>=sUp.length()) {
                            multiDimensionalArray[i][j] = sLeft;
                        } else {
                            multiDimensionalArray[i][j] = sUp;
                        }
                    } else if (sLeft == null && sUp !=null) {
                        multiDimensionalArray[i][j] = sUp;
                    } else if (sLeft !=null && sUp == null) {
                        multiDimensionalArray[i][j] = sLeft;
                    }
                }
            }
        }


        String s = multiDimensionalArray[multiDimensionalArray.length - 1][multiDimensionalArray[0].length - 1];
        char[] chars = s.toCharArray();
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            characters.add(chars[i]);
        }
        return characters;
    }

    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        List<Character> longest = new ArrayList<>();

        for (int i = 0; i < chars1.length; i++) {
            int j = i, k = 0, k_match = 0;
            List<Character> tempLongest = new ArrayList<>();
            boolean match = false;
            while ((j < chars1.length && k <= chars2.length)) {
                if (k == chars2.length && !match) {
                    break;
                }
                if (k == chars2.length && match && j < chars1.length) {
                    j++;
                    k = k_match + 1;
                    continue;
                }
                if (chars1[j] == chars2[k]) {
                    tempLongest.add(chars1[j]);
                    k_match = k;
                    j++;
                    k++;
                    match = true;
                } else {
                    k++;
                }

            }
            if (tempLongest.size() > longest.size()) {
                longest = new ArrayList<>(tempLongest);
            }
        }

        return longest;
    }


}
