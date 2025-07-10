package com.chrzanop.coding.algoexpert.arrays.utils;

public class GreatestCommonDivisor {


    public static int gcdEuclides(int numerator, int denominator) {
        int a = numerator;
        int b = denominator;

        int prevModulo = 0;

        while (true) {
            int modulo = a % b;
            if (modulo == 0) break;
            if (modulo > 0) {
                prevModulo = modulo;
            }
            a = b;
            b = modulo;
        }

        return prevModulo > 0 ? prevModulo : b;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
