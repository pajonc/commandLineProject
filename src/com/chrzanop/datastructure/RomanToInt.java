package com.chrzanop.datastructure;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public static void main(String[] args) {

        System.out.println(romantToInt("CIV"));
        System.out.println(romantToInt("MCMXCIV"));

    }

    public static int romantToInt(String roman) {
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arabic = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        Map<Character, Integer> romanToArabic = new HashMap<>();
        romanToArabic.put('I', 1);
        romanToArabic.put('V', 5);
        romanToArabic.put('X', 10);
        romanToArabic.put('L', 50);
        romanToArabic.put('C', 100);
        romanToArabic.put('D', 500);
        romanToArabic.put('M', 1000);

        int result = romanToArabic.get(roman.charAt(roman.length() - 1));
        for (int i = roman.length() - 2; i >= 0; i--) {
            Integer val = romanToArabic.get(roman.charAt(i));
            if (result > val) {
                result = result - val;
            } else {
                result = result + val;
            }

        }


        return result;
    }
}
