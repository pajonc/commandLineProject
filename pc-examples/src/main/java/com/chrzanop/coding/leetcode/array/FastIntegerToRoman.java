package com.chrzanop.coding.leetcode.array;

public class FastIntegerToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(3749));
    }


    private static final int[] VALUES = {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };

    private static final String[] SYMBOLS = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };

    public static String intToRoman(int val) {

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < VALUES.length; i++) {
            String symbol = SYMBOLS[i];
            int value = VALUES[i];

            while (val>= value) {
                roman.append(symbol);
                val -= value;
            }


        }
        return roman.toString();
    }
}
