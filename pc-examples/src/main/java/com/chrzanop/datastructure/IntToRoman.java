package com.chrzanop.datastructure;

public class IntToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(133));
        System.out.println(intToRoman(2423));
        System.out.println(intToRoman(6));
    }

    public static String intToRoman(int value) {

        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arabic = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String roman = "";

        for (int i = 0; i < arabic.length; i++) {
            if (value / arabic[i] > 0) {
                int count = value / arabic[i];
                for (int j = 0; j < count; j++) {
                    roman += romans[i];
                }
                value = value % arabic[i];
            }
        }
        return roman;
    }

    public static void printGroups(int number) {
        while (number > 0) {
            System.out.println("Modulo: " + number % 10);
            number = number / 10;
            System.out.println("Number before: " + number * 10);
            System.out.println("Number after: " + number);
        }
    }
}
