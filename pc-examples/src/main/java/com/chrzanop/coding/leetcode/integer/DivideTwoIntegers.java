package com.chrzanop.coding.leetcode.integer;

public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        // Przypadek przepełnienia: -2^31 / -1 = 2^31, czego nie da się zapisać w int
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend < 0) != (divisor < 0);
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        // Część całkowita: algorytm bitowy
        long quotient = 0;
        long remainder = 0;

        for (int i = 31; i >= 0; i--) {                           // od najstarszego bitu do najmłodszego
            remainder = (remainder << 1) | ((a >> i) & 1);        // zsuń kolejną cyfrę
            if (remainder >= b) {                                 // fragment >= dzielnik?
                remainder -= b;                                   // odejmij
                quotient |= 1L << i;                              // zapisz 1 na tej pozycji
            }
        }

        int q = (int) (negative ? -quotient : quotient);
        int r = (int) (dividend - (long) q * divisor);
        System.out.println("Reszta: "+r);

//        // Część ułamkowa: reszta * 10 / dzielnik, powtarzane "decimals" razy
//        StringBuilder fraction = new StringBuilder();
//        for (int i = 0; i < 3; i++) {
//            remainder *= 10;
//            fraction.append(remainder / b);
//            remainder %= b;
//        }
//
//        System.out.println("Po przecinku: "+fraction);

        // Część ułamkowa: bez / i %
        StringBuilder fraction = new StringBuilder();
        int decimals = 3; // liczba miejsc po przecinku
        for (int i = 0; i < decimals; i++) {
            // remainder * 10 = remainder * 8 + remainder * 2 (same przesunięcia)
            long r10 = (remainder << 3) + (remainder << 1);

            // Wyznacz cyfrę 0..9 bit po bicie.
            // r10 < 10*b < 16*b, więc wystarczą 4 bity (k = 3..0)
            int digit = 0;
            for (int k = 3; k >= 0; k--) {
                long shifted = b << k;          // b * 2^k
                if (r10 >= shifted) {
                    r10 -= shifted;
                    digit |= 1 << k;
                }
            }

            fraction.append(digit);
            remainder = r10;                    // nowa reszta, zawsze < b
        }

        return (int) (negative ? -quotient : quotient);
    }

    public static void main(String[] args) {
        System.out.println("10/3 result: " + divide(10, 3));   // 3
//        System.out.println(divide(7, -3));   // -2
    }
}
